package org.ming.download.apimodule.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 账号信息Service
 * @author MingXiangjun
 * @create 2018-09-15 22:02
 **/
public interface AccountInfoService<T> {
    /**
     * 根据id查询账号信息列表
     * @param ids
     * @return
     */
    List<T> getAccountInfosByIds(List<String> ids);
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
    Page<T> getAccountIdByPage(Pageable page);

    T getAccountInfoById(String id);
}
