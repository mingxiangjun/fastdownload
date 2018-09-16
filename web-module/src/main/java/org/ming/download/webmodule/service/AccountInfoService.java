package org.ming.download.webmodule.service;

import org.ming.download.servicemodule.model.AccountInfo;

import java.util.List;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:22
 **/
public interface AccountInfoService {
    /**
     * 根据ids查询账号信息
     * @param ids
     * @return
     */
    public List<AccountInfo> getAccountInfoByIds(List<String> ids);
}
