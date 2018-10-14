package org.ming.download.webmodule.service;

import org.ming.download.apimodule.dto.AccountInfoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:22
 **/
public interface AccountInfoManageService {
    /**
     * 根据ids查询账号信息
     * @param ids
     * @return
     */
    List<AccountInfoDTO> getAccountInfoByIds(List<String> ids);

    /**
     * 获取账号信息表总记录
     * @return
     */
    long getAllAccountInfoCount();

    /**
     * 分页获取数据
     * @param page
     * @return
     */
    List<AccountInfoDTO> getAllAccountInfo(Pageable page);
}
