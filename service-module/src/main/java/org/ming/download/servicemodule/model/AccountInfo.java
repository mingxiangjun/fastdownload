package org.ming.download.servicemodule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 账号信息
 *
 * @author MingXiangjun
 * @create 2018-09-15 21:40
 */
@Data
@Entity
@Table(name = "account_")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo implements Serializable{
    // 主键id
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "uuid")
    private String id;
    // 人员账号
    @Column(name = "user_name")
    private String userName;
    // 账号密码
    @Column(name = "password")
    private String password;
    // 安全邮箱
    @Column(name = "email")
    private String email;
    // 安全问题
    @Column(name = "security_ques")
    private String securityQues;
    // 安全问题答案
    @Column(name = "security_ans")
    private String securityAns;
    // 创建时间
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "salt")
    private String salt;
}
