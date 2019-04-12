package com.reptilesysem.system.core.pojo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SearchHistory {
	
	@Id
	@GeneratedValue(generator = "id")    
	@GenericGenerator(name = "id", strategy = "uuid") 
	private String id;
	
	private String value;//搜索内容

	private Date createDate;
	
	private Boolean isSuccess;//是否成功

	public SearchHistory(String value) {
	    this.createDate = new Date();
	    this.isSuccess = true;
		this.value = value;
	}

	public static SearchHistory getBySiteName(String siteName){
		return new SearchHistory(siteName);
	}
}
