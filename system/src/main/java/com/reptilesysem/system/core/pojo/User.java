package com.reptilesysem.system.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 系统用户，计划将权限信息保存在permission模块中
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name = "uid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String username;

    @JsonIgnore//不需要传给前端
    @Column(nullable = false)
    private String password;//计划采用md5加盐值加密保存在数据库中

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createDate;

    @LastModifiedDate
    @Column(nullable = true)
    private Date lastUpdateTime;

}

