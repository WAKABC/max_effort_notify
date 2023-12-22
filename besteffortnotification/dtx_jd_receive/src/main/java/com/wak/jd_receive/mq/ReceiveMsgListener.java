package com.wak.jd_receive.mq;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.fastjson.JSON;
import com.wak.entities.cm.AccountRecharge;
import com.wak.entities.jd.AccountCharge;
import com.wak.entities.model.AccountChangeEvent;
import com.wak.jd_receive.service.AccountChargeService;
import com.wak.jd_receive.service.AccountInfoService;
import com.wak.jd_receive.service.DeDuplicateService;
import com.wak.utils.CustomBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wuankang
 * @date 2023/11/9 10:08
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "comsumer_notifymsg", topic = "top_notifymsg")
public class ReceiveMsgListener implements RocketMQListener<AccountRecharge> {

    @Resource
    private AccountChargeService accountChargeServiceImpl;

    @Resource
    private AccountInfoService accountInfoServiceImpl;

    @Resource
    private DeDuplicateService deDuplicateServiceImpl;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onMessage(AccountRecharge message) {
        log.info("监听到队列中有消息, message:{}", JSON.toJSONString(message));
        if (idempotent(message)) return;
        AccountCharge accountCharge = BeanUtil.copyProperties(message, AccountCharge.class);
        if (ObjUtil.isEmpty(accountCharge)) return;
        //converter accountChangeEvent
        AccountChangeEvent accountChangeEvent = CustomBeanUtils.copyPropertiesByAccountCharge(accountCharge);
        //insert accountInfo
        saveData(message, accountChangeEvent, accountCharge);
        log.info("消息处理完成...");
    }


    /**
     * 保存数据
     *
     * @param message            消息
     * @param accountChangeEvent 账户变更事件
     * @param accountCharge      账户收取
     */
    private void saveData(AccountRecharge message, AccountChangeEvent accountChangeEvent, AccountCharge accountCharge) {
        accountInfoServiceImpl.updateAccountBalanceByAccountNo(accountChangeEvent);
        accountChargeServiceImpl.insert(accountCharge);
        deDuplicateServiceImpl.insert(message.getId());
    }

    /**
     * 幂等
     *
     * @param message 消息
     * @return boolean
     */
    private boolean idempotent(AccountRecharge message) {
        if (deDuplicateServiceImpl.idempotent(message.getId())) {
            log.info("重复消息，此处不处理...");
            return true;
        }
        return false;
    }
}
