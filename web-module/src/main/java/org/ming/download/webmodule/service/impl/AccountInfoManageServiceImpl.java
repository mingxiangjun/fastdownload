package org.ming.download.webmodule.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.ming.download.apimodule.dto.AccountInfoDTO;
import org.ming.download.apimodule.service.AccountInfoProvideService;
import org.ming.download.webmodule.service.AccountInfoManageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:23
 */
@Service
public class AccountInfoManageServiceImpl implements AccountInfoManageService {
    @Reference
    AccountInfoProvideService<AccountInfoDTO> accountInfoService;
    @Override
    public List<AccountInfoDTO> getAccountInfoByIds(List<String> ids) {
        return accountInfoService.getAccountInfoByIds(ids);
    }

    /**
     * 获取账号信息表总记录
     *
     * @return
     */
    @Override
    public long getAllAccountInfoCount() {
        return accountInfoService.getAllAccountInfoCount();
    }

    /**
     * 分页获取数据
     *
     * @param page
     * @return
     */
    @Override
    public List<AccountInfoDTO> getAllAccountInfo(Pageable page) {
        return accountInfoService.getAllAcountInfo(page.getPageNumber(),page.getPageSize());
    }

    /**
     * 根据id查询账号信息
     *
     * @param id
     * @return
     */
    @Override
    public AccountInfoDTO getAccountInfoById(String id) {
        return accountInfoService.getAccountInfoById(id);
    }
}
