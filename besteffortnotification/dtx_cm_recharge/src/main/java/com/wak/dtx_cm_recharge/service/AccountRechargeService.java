package com.wak.dtx_cm_recharge.service;

import com.wak.entities.cm.AccountRecharge;

/**
 * @author wuankang
 * @date 2023/11/8 17:46
 * @Description TODO
 * @Version 1.0
 */
public interface AccountRechargeService{
    AccountRecharge recharge(String accountNo, double amount);
    AccountRecharge selectById(String id);
}
