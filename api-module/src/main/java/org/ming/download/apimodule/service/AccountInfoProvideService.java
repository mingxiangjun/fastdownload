package org.ming.download.apimodule.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 提供远程使用AccountService
 *
 * @author MingXiangjun
 * @create 2018-09-15 19:04
 **/
public interface AccountInfoProvideService<T> {
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

    List<T> getAllAcountInfo(Integer pageNo,Integer pageSize);
}
