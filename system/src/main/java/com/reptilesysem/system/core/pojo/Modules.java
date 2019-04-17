package com.reptilesysem.system.core.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *  	规则模型
 * @author Elliot
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@Table(name="system_modules")
public class Modules {
	
	@Id
	@GeneratedValue(generator = "mid")    
	@GenericGenerator(name = "mid", strategy = "uuid") 
	private String mid;

	@Column(nullable = false)
	private String mouName;

	@CreationTimestamp
	@Column(nullable=true)
	private Timestamp createDate;

	@LastModifiedDate
	@Column(nullable=true)
	private Date lastUpdateDate;
	
	@JoinColumn(name="mid")
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Rules.class)
	private List<Rules> rules;
	
	@JoinColumn(name="mid")
	@OneToMany(cascade=CascadeType.ALL, targetEntity=HtmlAnalysis.class)
	private List<HtmlAnalysis> htmlAnalysies;
	
	@Column(nullable=true, columnDefinition="INT default 1")
	private int status;

	public Modules(String mouName) {
		super();
		this.mouName = mouName;
	}

	public Modules(String mouName, int status) {
		this.mouName = mouName;
		this.status = status;
	}
}
