package org.ming.download.servicemodule.provideservice;

import java.util.List;

/**
 * 提供远程使用AccountService
 *
 * @author MingXiangjun
 * @create 2018-09-15 19:04
 **/
public interface AccountInfoProvideService {
    List getAccountInfoByIds(List<String> ids);
}
