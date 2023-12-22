package com.wak.jd_receive.service;

import com.wak.entities.jd.AccountCharge;

/**
 * @author wuankang
 * @date 2023/11/8 23:34
 * @Description TODO
 * @Version 1.0
 */
public interface AccountChargeService{
    /**
     * 插入
     *
     * @param accountCharge 账户收取
     * @return int
     */
    int insert(AccountCharge accountCharge);
}
