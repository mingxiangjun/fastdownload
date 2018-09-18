package org.ming.download.webmodule.task;

import org.ming.download.commonmodult.CommonConfig;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.webmodule.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 导出excel文件异步任务
 *
 * @author MingXiangjun
 * @create 2018-09-18 20:57
 */
@Component
public class ExportAsyncTask {
    @Autowired
    AccountInfoService accountInfoService;

    @Async
    public Future<List<AccountInfo>> queryAccountInfoByIds(List<String> ids){
        List<AccountInfo> accountInfoByIds = accountInfoService.getAccountInfoByIds(ids);
        return new AsyncResult<List<AccountInfo>>(accountInfoByIds);
    }
}
