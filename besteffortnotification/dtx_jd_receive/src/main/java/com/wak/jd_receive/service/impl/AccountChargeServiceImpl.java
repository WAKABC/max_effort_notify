package com.wak.jd_receive.service.impl;

import com.wak.entities.jd.AccountCharge;
import com.wak.jd_receive.mapper.AccountChargeMapper;
import com.wak.jd_receive.service.AccountChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuankang
 * @date 2023/11/8 23:34
 * @Description TODO
 * @Version 1.0
 */
@Service
public class AccountChargeServiceImpl implements AccountChargeService {

    @Resource
    private AccountChargeMapper accountChargeMapper;

    @Override
    public int insert(AccountCharge accountCharge) {
        return accountChargeMapper.insert(accountCharge);
    }
}
