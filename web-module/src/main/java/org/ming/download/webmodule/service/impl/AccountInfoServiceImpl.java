package org.ming.download.webmodule.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.servicemodule.provideservice.AccountInfoProvideService;
import org.ming.download.webmodule.service.AccountInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:23
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Reference
    AccountInfoProvideService accountInfoService;
    public List<AccountInfo> getAccountInfoByIds(List<String> ids) {
        return accountInfoService.getAccountInfoByIds(ids);
    }

    /**
     * 获取账号信息表总记录
     *
     * @return
     */
    public long getAllAccountInfoCount() {
        return accountInfoService.getAllAccountInfoCount();
    }
}
