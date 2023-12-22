package com.wak.jd_receive.mapper;
import org.apache.ibatis.annotations.Param;

import com.wak.entities.jd.AccountCharge;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wuankang
 * @version 1.0.0
 * @date 2023/11/08
 * @description TODO
 */
public interface AccountChargeMapper extends Mapper<AccountCharge> {
    /**
     * 按id计数,幂等查询
     * @param id id
     * @return {@code Integer}
     */
    Integer countById(@Param("id")String id);

    /**
     * 按id更新
     * @param state 更新状态
     * @param id    事务流水
     * @return int
     */
    int updateStateById(@Param("state")String state, @Param("id")String id);
}