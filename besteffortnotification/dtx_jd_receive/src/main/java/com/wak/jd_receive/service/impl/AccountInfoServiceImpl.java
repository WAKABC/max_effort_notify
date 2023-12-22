package com.wak.jd_receive.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.wak.entities.cm.AccountRecharge;
import com.wak.entities.constant.SystemConstant;
import com.wak.entities.model.AccountChangeEvent;
import com.wak.api.RemoteRechargeClient;
import com.wak.jd_receive.mapper.AccountChargeMapper;
import com.wak.jd_receive.mapper.AccountInfoMapper;
import com.wak.jd_receive.mapper.DeDuplicateMapper;
import com.wak.jd_receive.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wuankang
 * @date 2023/11/8 23:03
 * @Description TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {
    @Resource
    private AccountInfoMapper accountInfoMapper;

    @Resource
    private DeDuplicateMapper duplicateMapper;

    @Resource
    private RemoteRechargeClient remoteRechargeClient;

    @Resource
    private AccountChargeMapper accountChargeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAccountBalanceByAccountNo(AccountChangeEvent accountChangeEvent) {
        //幂等
        if (duplicateMapper.countByTxno(accountChangeEvent.getTxNo()) > 0) {
            log.info("重复交易，流水号:{}", accountChangeEvent.getTxNo());
            return;
        }
        accountInfoMapper.updateAccountBalanceByAccountNo(accountChangeEvent.getAmount(), accountChangeEvent.getAccountNo());
    }

    /**
     * openfeign远程调用中国移动接口查询充值结果
     *
     * @param txNo txno
     * @return {@code AccountRecharge}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountRecharge queryRechargeResult(String txNo) {
        AccountRecharge accountRecharge = remoteRechargeClient.checkResult(txNo);
        if (ObjUtil.isNotEmpty(accountRecharge) && StrUtil.equals(SystemConstant.SUCCESS_RECHARGE_STATE, accountRecharge.getState())) {
            //更新京东侧的充值信息表
            accountChargeMapper.updateStateById(accountRecharge.getState(), accountRecharge.getId());
        }
        return accountRecharge;
    }
}
