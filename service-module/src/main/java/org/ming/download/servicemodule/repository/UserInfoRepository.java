package org.ming.download.servicemodule.repository;

import org.ming.download.servicemodule.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MingXiangjun
 * @create 2018-09-25 21:04
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
}
