package com.reptilesysem.system.core.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  	规则模型
 * @author Elliot
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_moudles")
@DynamicInsert
public class Moudles {
	
	@Id
	@GeneratedValue(generator = "mid")    
	@GenericGenerator(name = "mid", strategy = "uuid") 
	private String mid;
	
	private String mouName;
	
	@Column(nullable=true)
	private Date createDate;
	
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

	public Moudles(String mouName) {
		super();
		this.mouName = mouName;
		this.createDate = new Date();
		this.lastUpdateDate = new Date();
	}

	public Moudles(String mouName, Date createDate, Date lastUpdateDate, int status) {
		this.mouName = mouName;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.status = status;
	}
}
