package com.wak.jd_receive.service;

/**
 * @author wuankang
 * @date 2023/11/9 12:12
 * @Description TODO
 * @Version 1.0
 */
public interface DeDuplicateService {
    /**
     * 幂等
     *
     * @param txNo tx编号
     * @return {@code Boolean}
     */
    Boolean idempotent(String txNo);

    /**
     * 插入
     *
     * @param txNo tx编号
     */
    void insert(String txNo);
}
