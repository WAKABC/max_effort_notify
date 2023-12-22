package com.wak.api;

import com.wak.entities.cm.AccountRecharge;
import com.wak.api.fallback.RechargeFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuankang
 * @date 2023/11/8 23:58
 * @Description TODO
 * @Version 1.0
 */
@FeignClient(name = "dtx-cm-charge", fallback = RechargeFallBack.class)
public interface RemoteRechargeClient {
    /**
     * 状态查询接口
     * @param txNo id
     * @return {@code AccountRecharge}
     */
    @GetMapping("recharge/checkResult/{txNo}")
    AccountRecharge checkResult(@PathVariable("txNo") String txNo);
}
