package com.wak.jd_receive.service.impl;

import com.wak.jd_receive.mapper.DeDuplicateMapper;
import com.wak.jd_receive.service.DeDuplicateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuankang
 * @date 2023/11/9 12:13
 * @Description TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class DeDuplicateServiceImpl implements DeDuplicateService {

    @Resource
    private DeDuplicateMapper deDuplicateMapper;

    /**
     * 幂等
     *
     * @param txNo 事务流水
     * @return {@code Boolean}
     */
    @Override
    public Boolean idempotent(String txNo) {
        Integer count = deDuplicateMapper.countByTxno(txNo);
        return count > 0;
    }

    /**
     * 插入
     *
     * @param txNo 事务流水
     */
    @Override
    public void insert(String txNo) {
        deDuplicateMapper.addDuplicate(txNo);
    }
}
