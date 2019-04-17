package com.reptilesysem.system.core.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "system_htmlInfo")
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class HtmlInfo {

    @Id
    @GeneratedValue(generator = "html_id")
    @GenericGenerator(name = "html_id", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    /**
     * spring data jpa 存储大型文本注解
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    @Column(name = "html")
    private String html;

    @Column(name = "url")
    private String url;
    
    @Column(nullable=true)
    private String type;

    @CreationTimestamp
    @Column(nullable=true)
    private Timestamp createTime;
    
    @Column(nullable=true)
    private Date lastUpdateTime;
    
    @Column(nullable=true, columnDefinition="INT default 1")
    private int status;
    

    public HtmlInfo(String name, String html, String url) {
        this.name = name;
        this.html = html;
        this.url = url;
    }
}
