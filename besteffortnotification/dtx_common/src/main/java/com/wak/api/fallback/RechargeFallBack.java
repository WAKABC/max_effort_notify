package com.wak.api.fallback;

import com.wak.api.RemoteRechargeClient;
import com.wak.entities.cm.AccountRecharge;
import org.springframework.stereotype.Component;

/**
 * @author wuankang
 * @version 1.0.0
 * @date 2023/11/09
 * @description TODO 服务降级，openfeign调用超时兜底方案
 */
@Component
public class RechargeFallBack implements RemoteRechargeClient {
    @Override
    public AccountRecharge checkResult(String txNo) {
        return new AccountRecharge(txNo ,"00000000",0.00,"nu-know");
    }
}
