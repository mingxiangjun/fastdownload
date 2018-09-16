package org.ming.download.webmodule.controller;

import com.alibaba.fastjson.JSONObject;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.webmodule.service.AccountInfoService;
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
    private AccountInfoService accountInfoService;

    @RequestMapping(value = "/list")
    public JSONObject getAccountInfoByIds(@RequestParam(value = "ids")String ids){
        List<AccountInfo> accountInfoByIds = accountInfoService.getAccountInfoByIds(Arrays.asList(ids.split(",")));

        JSONObject result = new JSONObject();
        result.put("code","ok");
        result.put("data",accountInfoByIds);
        return result;
    }
}
