package com.wak.jd_receive.mapper;
import org.apache.ibatis.annotations.Param;

import com.wak.entities.jd.AccountInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wuankang
 * @date 2023/11/8 23:00
 * @Description TODO
 * @Version 1.0
 */
public interface AccountInfoMapper extends Mapper<AccountInfo> {
    /**
     * 更新账户平衡根据账户编号
     *
     * @param amount    量
     * @param accountNo 账户编号
     * @return int
     */
    int updateAccountBalanceByAccountNo(@Param("amount")Double amount, @Param("accountNo")String accountNo);
}