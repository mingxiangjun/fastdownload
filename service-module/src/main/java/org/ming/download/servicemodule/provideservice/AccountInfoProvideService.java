package org.ming.download.servicemodule.provideservice;

import java.util.List;

/**
 * 提供远程使用AccountService
 *
 * @author MingXiangjun
 * @create 2018-09-15 19:04
 **/
public interface AccountInfoProvideService {
    /**
     * 根据Id查询账号信息
     * @param ids
     * @return
     */
    List getAccountInfoByIds(List<String> ids);

    /**
     * 查询库表总记录数
     * @return
     */
    long getAllAccountInfoCount();
}
