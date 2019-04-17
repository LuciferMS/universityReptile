package com.reptilesysem.system.core.util.log.pojo;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *	 搜索记录
 * @author Elliot
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="system_history")
@EntityListeners(AuditingEntityListener.class)
public class SearchHistory {
	
	@Id
	@GeneratedValue(generator = "id")    
	@GenericGenerator(name = "id", strategy = "uuid") 
	private String id;

    /**
     * 搜素内容
     */
	@Column(nullable = false)
	private String value;

	@Column(nullable = false)
	private String path;

    /**
     * 搜索时间
     */
    @CreationTimestamp
    @Column(nullable = false)
	private Timestamp createDate;

    /**
     * 是否成功..
     */
    @Column(nullable = false, columnDefinition="INT default 0")
	private Boolean isSuccess;


    public static SearchHistory builderOfSuccess(){
        SearchHistory searchHistory = new SearchHistory();
        return searchHistory.success();
    }

    public static SearchHistory builderOfFail(){
        SearchHistory searchHistory = new SearchHistory();
        return searchHistory.fail();
    }


    public SearchHistory success(){
        this.isSuccess = true;
        return this;
    }

    public SearchHistory fail(){
        this.isSuccess = false;
        return this;
    }

    public SearchHistory value(String value){
        this.value = value;
        return this;
    }
}
