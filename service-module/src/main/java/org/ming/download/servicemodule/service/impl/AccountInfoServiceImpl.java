package org.ming.download.servicemodule.service.impl;

import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.servicemodule.repository.AccountInfoRepository;
import org.ming.download.servicemodule.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号信息服务类实现
 *
 * @author MingXiangjun
 * @create 2018-09-15 23:43
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Autowired
    AccountInfoRepository accountInfoRepository;
    /**
     * 根据id查询账号信息列表
     *
     * @param ids
     * @return
     */
    public List<AccountInfo> getAccountInfosByIds(List<String> ids) {
        return accountInfoRepository.queryAccountInfosByIdIn(ids);
    }
}
