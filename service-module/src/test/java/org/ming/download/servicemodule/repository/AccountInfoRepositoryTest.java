package org.ming.download.servicemodule.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ming.download.servicemodule.ServiceProviderApplication;
import org.ming.download.servicemodule.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceProviderApplication.class)
public class AccountInfoRepositoryTest {
    @Autowired
    private AccountInfoRepository accountInfoRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTemplateTest(){
        int totalCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "account_");
        log.info("totalCount is {}",totalCount);
    }
    @Test
    public void queryAccountInfosById() throws Exception {
        String ids = "000004c08ddf42a180a72af93572a636,0000149bebca40d3835f275d8dd027b0,00001e0f26c4491abc40d1e141e01209";
        List<AccountInfo> accountInfos = accountInfoRepository.queryAccountInfosByIdIn(Arrays.asList(ids.split(",")));
        log.info("totalCount is {}",accountInfos);
    }

    @Test
    public void queryAccountInfoById() throws Exception {
        AccountInfo accountInfo = accountInfoRepository.queryAccountInfoById("000004c08ddf42a180a72af93572a636");
        log.info(accountInfo);
    }

    @Test
    public void saveAccountInfo(){
        AccountInfo accountInfo = AccountInfo.builder().userName("nameset").email("test@qq.com").build();
        accountInfoRepository.save(accountInfo);
        log.info(accountInfoRepository.queryAccountInfoById(accountInfo.getId()));
    }

    @Test
    public void count(){
        log.info("record count is "+accountInfoRepository.count());
    }

    @Test
    public void queryByPage(){
        PageRequest page = PageRequest.of(1,20);
        List<AccountInfo> accountInfos = accountInfoRepository.queryAccountInfos(page);
        log.info("page accountInfo is :"+accountInfos);
    }
}
