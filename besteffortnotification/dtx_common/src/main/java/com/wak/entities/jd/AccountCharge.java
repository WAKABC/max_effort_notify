package com.wak.entities.jd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuankang
 * @version 1.0.0
 * @date 2023/12/22
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCharge implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 事务流水
     */
    private String id;

    /**
     * 充值帐户
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