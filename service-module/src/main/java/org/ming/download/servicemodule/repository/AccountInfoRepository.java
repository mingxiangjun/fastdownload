package org.ming.download.servicemodule.repository;

import org.ming.download.servicemodule.model.AccountInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 账号数据库操作Repository
 * @author MingXiangjun
 * @create 2018-09-15 21:54
 **/
public interface AccountInfoRepository extends JpaRepository<AccountInfo,String> {
    List<AccountInfo> queryAccountInfosByIdIn(List<String> ids);
    AccountInfo queryAccountInfoById(String id);
    List<AccountInfo> queryAccountInfos(Pageable page);
}
