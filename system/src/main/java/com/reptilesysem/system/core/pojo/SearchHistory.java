package com.reptilesysem.system.core.pojo;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
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
@Table(name="t_history")
@EntityListeners(AuditingEntityListener.class)
public class SearchHistory {
	
	@Id
	@GeneratedValue(generator = "id")    
	@GenericGenerator(name = "id", strategy = "uuid") 
	private String id;

	@Column(nullable = false)
	private String value;//搜索内容

    @CreatedDate
    @Column(nullable = false)
	private Date createDate;

    @Column(nullable = false)
	private Boolean isSuccess;//是否成功


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
