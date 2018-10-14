package org.ming.download.servicemodule.provideservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.ming.download.apimodule.dto.AccountInfoDTO;
import org.ming.download.commonmodule.util.PageInfoUtil;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.apimodule.service.AccountInfoProvideService;
import org.ming.download.apimodule.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * dubbo服务实现类
 *
 * @author MingXiangjun
 * @create 2018-09-16 10:41
 */
@Service(interfaceClass = AccountInfoProvideService.class,timeout = 8000)
@Component
public class AccountInfoInfoProvideServiceImpl implements AccountInfoProvideService<AccountInfoDTO> {
    @Autowired
    private AccountInfoService accountInfoService;

    public List<AccountInfoDTO> getAccountInfoByIds(List<String> ids) {
        List<AccountInfo> accountInfos = accountInfoService.getAccountInfosByIds(ids);
        return accountInfos.stream().map(this::entityConvert).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 查询库表总记录数
     *
     * @return
     */
    public long getAllAccountInfoCount() {
        return accountInfoService.getAllAccountInfoCount();
    }

    public List<AccountInfoDTO> getAllAcountInfo(Integer pageNo,Integer pageSize) {
        PageRequest page = PageInfoUtil.initPageInfo(pageNo,pageSize);
        Page<AccountInfo> accountInfo = accountInfoService.getAccountIdByPage(page);
        return accountInfo.getContent().stream().map(this::entityConvert).collect(Collectors.toCollection(ArrayList::new));
    }

    private AccountInfoDTO entityConvert(AccountInfo info){
        return AccountInfoDTO.builder().createTime(info.getCreateTime()).email(info.getEmail()).password(info.getPassword()).salt(info.getSalt()).securityAns(info.getSecurityAns()).securityQues(info.getSecurityQues()).userName(info.getUserName()).build();
    }
}
