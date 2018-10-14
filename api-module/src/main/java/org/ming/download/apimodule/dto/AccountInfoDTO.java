package org.ming.download.apimodule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author MingXiangjun
 * @create 2018-10-14 16:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfoDTO implements Serializable{
    private String userName;
    // 账号密码
    private String password;
    // 安全邮箱
    private String email;
    // 安全问题
    private String securityQues;
    // 安全问题答案
    private String securityAns;
    // 创建时间
    private Date createTime;
    private String salt;
}
