package org.ming.download.servicemodule.provideservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.ming.download.servicemodule.provideservice.AccountInfoProvideService;
import org.ming.download.servicemodule.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * dubbo服务实现类
 *
 * @author MingXiangjun
 * @create 2018-09-16 10:41
 */
@Service(interfaceClass = AccountInfoProvideService.class,timeout = 8000)
@Component
public class AccountInfoInfoProvideServiceImpl implements AccountInfoProvideService {
    @Autowired
    private AccountInfoService accountInfoService;

    public List getAccountInfoByIds(List<String> ids) {
        return accountInfoService.getAccountInfosByIds(ids);
    }

    /**
     * 查询库表总记录数
     *
     * @return
     */
    public long getAllAccountInfoCount() {
        return accountInfoService.getAllAccountInfoCount();
    }
}
