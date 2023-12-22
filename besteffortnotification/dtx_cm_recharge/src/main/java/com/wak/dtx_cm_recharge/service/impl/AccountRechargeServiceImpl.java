package com.wak.dtx_cm_recharge.service.impl;

import com.wak.dtx_cm_recharge.mapper.AccountRechargeMapper;
import com.wak.dtx_cm_recharge.service.AccountRechargeService;
import com.wak.entities.cm.AccountRecharge;
import com.wak.utils.AssembleObjectUtil;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wuankang
 * @date 2023/11/8 17:46
 * @Description TODO
 * @Version 1.0
 */
@Service
public class AccountRechargeServiceImpl implements AccountRechargeService{

    @Resource
    private AccountRechargeMapper accountRechargeMapper;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 充值接口
     *
     * @param accountNo 帐户号码
     * @param amount    金额
     * @return {@code AccountRecharge}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountRecharge recharge(String accountNo, double amount) {
        AccountRecharge accountRecharge = AssembleObjectUtil.assembleRecharge(accountNo, amount);
        int result = accountRechargeMapper.insert(accountRecharge);
        if (result > 0){
            //send message to mq
            rocketMQTemplate.convertAndSend("top_notifymsg", accountRecharge);
        }
        return accountRecharge;
    }

    /**
     * 根据主键查询数据
     *
     * @param id id
     * @return {@code AccountRecharge}
     */
    @Override
    public AccountRecharge selectById(String id) {
        return accountRechargeMapper.selectById(id);
    }
}
