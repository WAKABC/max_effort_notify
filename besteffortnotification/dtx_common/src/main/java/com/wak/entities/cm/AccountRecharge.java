package com.wak.entities.cm;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuankang
 * @date 2023/11/8 18:04
 * @Description TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRecharge implements Serializable {
    /**
     * 京东充值流水号
     */
    private String id;

    /**
     * 帐户号码
     */
    private String accountNo;

    /**
     * 充值金额
     */
    private Double rechargeAmount;

    /**
     * 充值状态
     */
    private String state;
}