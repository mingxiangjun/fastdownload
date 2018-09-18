package org.ming.download.servicemodule.service;

import org.ming.download.servicemodule.model.AccountInfo;
import org.springframework.data.domain.Page;

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
    /**
     * 查询库表总记录数
     * @return
     */
    long getAllAccountInfoCount();

    /**
     * 按照分页信息获取账号信息
     * @param page
     * @return
     */
    Page<AccountInfo> getAccountIdByPage(Page page);
}
