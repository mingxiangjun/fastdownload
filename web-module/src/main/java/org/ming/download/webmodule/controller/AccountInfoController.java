package org.ming.download.webmodule.controller;

import com.alibaba.fastjson.JSONObject;
import javafx.scene.chart.ValueAxis;
import lombok.extern.log4j.Log4j2;
import org.ming.download.apimodule.dto.AccountInfoDTO;
import org.ming.download.commonmodule.config.CommonConfig;
import org.ming.download.commonmodule.util.PageInfoUtil;
import org.ming.download.commonmodule.util.ResultJsonUtil;
import org.ming.download.webmodule.service.AccountInfoManageService;
import org.ming.download.webmodule.task.ExportAsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 账号信息前端控制器
 *
 * @author MingXiangjun
 * @create 2018-09-16 11:30
 */
@Log4j2
@RestController
@RequestMapping(value = "/account")
public class AccountInfoController {
    @Autowired
    CommonConfig commonConfig;

    @Autowired
    ExportAsyncTask exportAsyncTask;

    @Autowired
    private AccountInfoManageService accountInfoManageService;

    @RequestMapping(value = "/list/{ids}")
    public JSONObject getAccountInfoByIds(@PathVariable(value = "ids") String ids) {
        List<AccountInfoDTO> accountInfoByIds = accountInfoManageService.getAccountInfoByIds(Arrays.asList(ids.split(",")));

        JSONObject result = new JSONObject();
        result.put("code", "ok");
        result.put("data", accountInfoByIds);
        return result;
    }
    @RequestMapping(value = "/list/page")
    public JSONObject getAccountInfoByPage(@RequestParam(value = "pageSize")Integer pageSize, @RequestParam(value = "pageNo")Integer pageNo){
        PageRequest pageInfo = PageInfoUtil.initPageInfo(pageNo,pageSize);
        List<AccountInfoDTO> results = accountInfoManageService.getAllAccountInfo(pageInfo);
        return ResultJsonUtil.success("查询成功！").data(results).toJson();
    }
    @RequestMapping(value = "/export")
    public JSONObject exportAllAccountInfo() throws ExecutionException, InterruptedException {
        long allCount = accountInfoManageService.getAllAccountInfoCount();
        log.info("total count is {}", allCount);
        int batchSizeLimit = Integer.parseInt(commonConfig.get("batchSizeLimit").toString());
        long pageCount = allCount % batchSizeLimit == 0 ? allCount / batchSizeLimit : allCount / batchSizeLimit + 1;
        log.info("total page is {}",pageCount);
        List<Future<List<AccountInfoDTO>>> tasks = new ArrayList<Future<List<AccountInfoDTO>>>((int) pageCount);
        for (int i = 1; i <= pageCount; i++) {
            PageRequest pageRequest = PageRequest.of(i, batchSizeLimit);
            Future<List<AccountInfoDTO>> task = exportAsyncTask.queryAccountInfoByIds(pageRequest);
            tasks.add(task);
        }

        Calendar instance = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        log.info("start time is {}", sdf.format(instance.getTime()));
        instance.add(Calendar.MINUTE, 30);
        long endTime = instance.getTimeInMillis();
        log.info("max end time is {}",sdf.format(endTime));
        while (true) {
            for (int i = tasks.size() - 1; i >= 0; i--) {
                Future<List<AccountInfoDTO>> curTask = tasks.get(i);
                if (curTask.isDone()) {
                    tasks.remove(curTask);
                    List<AccountInfoDTO> accountInfos = curTask.get();
                    log.info("task result is {}", accountInfos);
                    log.info("task finish , the last task count is {}", tasks.size());
                }
            }
            if (tasks.size() == 0 || System.currentTimeMillis() > endTime) {
                // 超时或任务完成退出
                if (tasks.size() > 0) {
                    log.error("任务未完成，超时结束！current time is {}",sdf.format(instance.getTime()));
                }
                break;
            }
        }
        return ResultJsonUtil.success("稍等片刻。。。。").toJson();
    }
}
