package com.wak.utils;

import cn.hutool.core.convert.Converter;
import com.wak.entities.jd.AccountCharge;
import com.wak.entities.model.AccountChangeEvent;

/**
 * @author wuankang
 * @date 2023/11/9 11:50
 * @Description TODO
 * @Version 1.0
 */
public class CustomBeanUtils {

    /**
     * AccountCharge转换AccountChangeEvent
     *
     * @param accountCharge 账户充值对象
     * @return {@code AccountChangeEvent}
     */
    public static AccountChangeEvent copyPropertiesByAccountCharge(AccountCharge accountCharge) {
        AccountChangeEventConverter accountChangeEventConverter = new AccountChangeEventConverter();
        return accountChangeEventConverter.convert(accountCharge, new AccountChangeEvent());
    }

    /**
     * @author wuankang
     * @version 1.0.0
     * @date 2023/11/09
     * @description TODO AccountCharge转换AccountChangeEvent 转换器
     */
    private static class AccountChangeEventConverter implements Converter<AccountChangeEvent> {
        @Override
        public AccountChangeEvent convert(Object o, AccountChangeEvent accountChangeEvent) throws IllegalArgumentException {
            if (o instanceof AccountCharge) {
                AccountCharge accountCharge = (AccountCharge) o;
                accountChangeEvent.setAccountNo(accountCharge.getAccountNo());
                accountChangeEvent.setAmount(accountCharge.getRechargeAmount());
                accountChangeEvent.setTxNo(accountCharge.getId());
                return accountChangeEvent;
            } else {
                throw new IllegalArgumentException("Unsupported conversion: " + o.getClass());
            }
        }
    }
}
