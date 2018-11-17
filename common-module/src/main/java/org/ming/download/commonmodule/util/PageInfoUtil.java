package org.ming.download.commonmodule.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;

/**
 * 分页工具类
 *
 * @author MingXiangjun
 * @create 2018-10-14 18:13
 */
@Log4j2
public class PageInfoUtil {
    private PageInfoUtil(){
        // default constructor
    }

    public static PageRequest initPageInfo(Integer pageNo,Integer pageSize){
        if (pageNo == null){
            pageNo = 1;
        }
        if (pageSize == null){
            pageSize = 20;
        }
        return PageRequest.of(pageNo,pageSize);
    }
}
