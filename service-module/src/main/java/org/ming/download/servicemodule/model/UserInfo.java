package org.ming.download.servicemodule.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * @author MingXiangjun
 * @create 2018-09-25 20:59
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    // 主键id
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "uuid")
    private String id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "address")
    private String address;
    @Column
    private int age;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "department_id")
    private String departymentId;
    @Column(name = "gender")
    private int gender;
    @Column(name = "real_name")
    private String realName;
}
