package org.ming.download.webmodule.controller;

import com.alibaba.fastjson.JSONObject;
import org.ming.download.commonmodult.CommonConfig;
import org.ming.download.commonmodult.util.ResultJsonUtil;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.webmodule.service.AccountInfoService;
import org.ming.download.webmodule.task.ExportAsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 账号信息前端控制器
 *
 * @author MingXiangjun
 * @create 2018-09-16 11:30
 */
@RestController
@RequestMapping(value = "/account")
public class AccountInfoController {
    @Autowired
    CommonConfig commonConfig;

    @Autowired
    ExportAsyncTask exportAsyncTask;

    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/list")
    public JSONObject getAccountInfoByIds(@RequestParam(value = "ids")String ids){
        List<AccountInfo> accountInfoByIds = accountInfoService.getAccountInfoByIds(Arrays.asList(ids.split(",")));

        JSONObject result = new JSONObject();
        result.put("code","ok");
        result.put("data",accountInfoByIds);
        return result;
    }
    @RequestMapping(value = "/export")
    public JSONObject exportAllAccountInfo(){
        long allCount = accountInfoService.getAllAccountInfoCount();
        int batchSizeLimit = Integer.parseInt(commonConfig.get("batchSizeLimit").toString());
        for (int i = 1;i<=allCount / batchSizeLimit +1;i++){
            int startIndex = (i-1)*batchSizeLimit;

        }
        return ResultJsonUtil.success("稍等片刻。。。。").toJson();
    }
}
