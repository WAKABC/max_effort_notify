package com.wak.dtx_cm_recharge.controller;

import com.wak.dtx_cm_recharge.service.AccountRechargeService;
import com.wak.entities.cm.AccountRecharge;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * account_recharge(account_recharge)表控制层
 *
 * @author xxxxx
 */
@RestController
public class AccountRechargeController {
    /**
     * 服务对象
     */
    @Resource(name = "accountRechargeServiceImpl")
    private AccountRechargeService accountRechargeService;

    /**
     * 充值接口
     *
     * @param accountNo 帐户号码
     * @param amount    充值金额
     * @return {@code AccountRecharge}
     */
    @GetMapping("/recharge")
    AccountRecharge recharge(@RequestParam String accountNo, @RequestParam double amount) {
        return accountRechargeService.recharge(accountNo, amount);
    }

    /**
     * 状态回查接口
     *
     * @param txNo 主键
     * @return 单条数据
     */
    @GetMapping("/recharge/checkResult/{txNo}")
    AccountRecharge checkResult(@PathVariable("txNo") String txNo) {
        return accountRechargeService.selectById(txNo);
    }

}
