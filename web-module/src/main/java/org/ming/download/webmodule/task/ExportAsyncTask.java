package org.ming.download.webmodule.task;

import lombok.extern.log4j.Log4j2;
import org.ming.download.apimodule.dto.AccountInfoDTO;
import org.ming.download.webmodule.service.AccountInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@Log4j2
@Component
public class ExportAsyncTask {
    @Autowired
    AccountInfoManageService accountInfoService;

    @Async
    public Future<List<AccountInfoDTO>> queryAccountInfoByIds(Pageable pageable){
        log.info("current page is {}",pageable.getPageNumber());
        List<AccountInfoDTO> accountInfoByIds = accountInfoService.getAllAccountInfo(pageable);
        return new AsyncResult<>(accountInfoByIds);
    }
}
