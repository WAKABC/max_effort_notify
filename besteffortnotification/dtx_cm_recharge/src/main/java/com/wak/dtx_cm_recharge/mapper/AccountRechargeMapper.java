package com.wak.dtx_cm_recharge.mapper;
import org.apache.ibatis.annotations.Param;

import com.wak.entities.cm.AccountRecharge;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wuankang
 * @date 2023/11/8 18:04
 * @Description TODO
 * @Version 1.0
 */
public interface AccountRechargeMapper extends Mapper<AccountRecharge> {

    /**
     * 按id查询
     *
     * @param id id
     * @return {@code AccountRecharge}
     */
    AccountRecharge selectById(@Param("id")String id);
}