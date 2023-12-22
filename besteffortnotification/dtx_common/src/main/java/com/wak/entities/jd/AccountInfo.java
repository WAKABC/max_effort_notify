package com.wak.entities.jd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuankang
 * @date 2023/11/8 23:00
 * @Description TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 帐户名称
     */
    private String accountName;

    /**
     * 帐户号码
     */
    private String accountNo;

    /**
     * 帐户余额
     */
    private Double accountBalance;

    private static final long serialVersionUID = 1L;
}