package org.ming.download.servicemodule.service.impl;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ming.download.servicemodule.ServiceProviderApplication;
import org.ming.download.servicemodule.model.AccountInfo;
import org.ming.download.apimodule.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceProviderApplication.class)
public class AccountInfoServiceImplTest {
    @Autowired
    private AccountInfoService service;

    @Test
    public void getAccountInfosByIds() throws Exception {
        String ids = "";
        service.getAccountInfosByIds(Arrays.asList(ids.split(",")));
    }

    @Test
    public void getAllAccountInfoCount() throws Exception {
        log.info(service.getAllAccountInfoCount());
        log.info("current time is {}",System.currentTimeMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        log.info(sdf.format(time));
        instance.add(Calendar.MINUTE,30);
        time = instance.getTime();
        log.info(sdf.format(time));
    }

    @Test
    public void getAccountIdByPage() throws Exception {
        PageRequest page = PageRequest.of(1,200);
        Page<AccountInfo> accountInfos = service.getAccountIdByPage(page);
        log.info(accountInfos.getTotalElements());
    }

    @Test
    public void foreachTest(){
        List<String> names = new ArrayList<String>(10);
        for (int i=0;i<10;i++){
            names.add("test"+i);
        }
        for(int i=names.size();i>0;i--){
            String name = names.get(i-1);
                names.remove(name);
            System.out.println(names);
        }
    }
}
