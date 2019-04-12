package com.reptilesysem.system.core.pojo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 	数据分析规则
 * @author Elliot
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_rules")
@DynamicInsert
public class Rules {
	@Id
	@GeneratedValue(generator = "rid")    
	@GenericGenerator(name = "rid", strategy = "uuid") 
	private String rid;
	
	private String ruleName;
	
//	@ManyToOne(targetEntity=Moudles.class)
//	@JoinColumn(name="mid")
//	private Moudles moudles;
	
	@Column(nullable=false)
	private String value;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private String mid;
	
	@Column(nullable=true)
	private Date createTime;
	
	@JoinColumn(name="rId")
	@OneToMany(cascade=CascadeType.ALL, targetEntity=HtmlAnalysis.class)
	private List<HtmlAnalysis> htmlAnalysies;
	
	@Column(nullable=true)
	private Date lastUpdateTime;
	
	@Column(nullable=true,columnDefinition="INT default 1")
	private int status;//状态
	
	@Column(nullable=true,columnDefinition="INT default 0")
	private int useTimes;//使用次数

	public Rules(String mid, String ruleName, String value, String ruleType) {
		super();
		this.mid = mid;
		this.value = value;
		this.ruleName = ruleName;
		this.type = ruleType;
		this.createTime = new Date();
		this.lastUpdateTime = new Date();
	}

	public Rules(String rid,String ruleName, String value, String type, String mid, Date createTime, Date lastUpdateTime, int status, int useTimes) {
		this.rid = rid;
		this.ruleName = ruleName;
		this.value = value;
		this.type = type;
		this.mid = mid;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
		this.useTimes = useTimes;
	}
}
