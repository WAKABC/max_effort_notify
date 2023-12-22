package com.wak.jd_receive.mapper;

import com.wak.entities.jd.DeDuplicate;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wuankang
 * @date 2023/11/8 23:52
 * @Description TODO
 * @Version 1.0
 */
public interface DeDuplicateMapper extends Mapper<DeDuplicate> {
    /**
     * 数根据txno
     *
     * @param txno txno
     * @return {@code Integer}
     */
    Integer countByTxno(@Param("txno") String txno);

    /**
     * 添加重复
     *
     * @param txno txno
     * @return {@code Integer}
     */
    Integer addDuplicate(@Param("txno") String txno);
}