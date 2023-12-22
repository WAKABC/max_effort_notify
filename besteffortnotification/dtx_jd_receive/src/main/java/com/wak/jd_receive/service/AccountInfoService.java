package com.wak.jd_receive.service;

import com.wak.entities.cm.AccountRecharge;
import com.wak.entities.model.AccountChangeEvent;

/**
 * @author wuankang
 * @date 2023/11/9 0:12
 * @Description TODO
 * @Version 1.0
 */
public interface AccountInfoService {
    /**
     * 更新账户平衡根据账户编号
     *
     * @param accountChangeEvent 账户变更事件
     */
    void updateAccountBalanceByAccountNo(AccountChangeEvent accountChangeEvent);

    /**
     * 查询充值结果
     *
     * @param txNo tx编号
     * @return {@code AccountRecharge}
     */
    AccountRecharge queryRechargeResult(String txNo);
}
