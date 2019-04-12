package com.reptilesysem.system.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_htmlQueueInfo")
@DynamicInsert
public class HtmlQueueInfo {
    @Id
    @GeneratedValue(generator = "page_id")
    @GenericGenerator(name = "page_id", strategy = "uuid")
    private String p_id;
    @Column(name = "s_id")
    private String s_id;
    @Column(name = "text")
    private String text;
    @Column(name = "href")
    private String href;
    @Column(name = "status")
    private String status;
    @Column(nullable=true)
    private Date createTime;
    @Column(nullable=true)
    private Date lastUpdateTime;

    public HtmlQueueInfo(String s_id, String text, String href, String status) {
        this.s_id = s_id;
        this.text = text;
        this.href = href;
        this.status = status;
    }
}
