package org.ming.download.servicemodule.service;

import org.ming.download.servicemodule.model.AccountInfo;

import java.util.List;

/**
 * 账号信息Service
 * @author MingXiangjun
 * @create 2018-09-15 22:02
 **/
public interface AccountInfoService {
    /**
     * 根据id查询账号信息列表
     * @param ids
     * @return
     */
    List<AccountInfo> getAccountInfosByIds(List<String> ids);
}
