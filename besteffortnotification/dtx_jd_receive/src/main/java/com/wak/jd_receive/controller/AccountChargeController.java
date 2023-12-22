package com.wak.jd_receive.controller;

import com.wak.entities.jd.AccountCharge;
import com.wak.jd_receive.service.impl.AccountChargeServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * account_charge(account_charge)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/account_charge")
public class AccountChargeController {
    /**
     * 服务对象
     */
    @Resource
    private AccountChargeServiceImpl accountChargeServiceImpl;

    /**
     * 新增数据
     *
     * @param accountCharge 新增对象
     * @return int
     */
    @GetMapping("/insert")
    public int insert(AccountCharge accountCharge) {
        return accountChargeServiceImpl.insert(accountCharge);
    }

}
