package com.wak.utils;

import cn.hutool.core.lang.UUID;
import com.wak.entities.cm.AccountRecharge;

/**
 * @author wuankang
 * @date 2023/11/9 11:32
 * @Description TODO 对象组装工具类
 * @Version 1.0
 */
public class AssembleObjectUtil {
    /**
     * 组装充值成功对象
     *
     * @param accountNo 帐户号码
     * @param amount    量
     * @return {@code AccountRecharge}
     */
    public static AccountRecharge assembleRecharge(String accountNo, double amount) {
        //生成充值对象
        AccountRecharge accountRecharge = new AccountRecharge();
        accountRecharge.setId(UUID.fastUUID().toString(true));
        accountRecharge.setAccountNo(accountNo);
        accountRecharge.setRechargeAmount(amount);
        accountRecharge.setState("success");
        return accountRecharge;
    }
}
