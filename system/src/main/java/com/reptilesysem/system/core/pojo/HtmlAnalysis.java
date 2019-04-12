package com.reptilesysem.system.core.pojo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_htmlAnalysis")
@DynamicInsert
public class HtmlAnalysis {
	
	@Id 
	@GeneratedValue(generator = "hid")    
	@GenericGenerator(name = "hid", strategy = "uuid") 
	private String hId;
	
//	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Rules.class)
//	@JoinColumn(name="hRuleId")
//	private Rules rules;
	
//	@ManyToOne(cascade=CascadeType.ALL, targetEntity=HtmlInfo.class)
//	@JoinColumn(name="htmlInfoId")
//	private HtmlInfo htmlInfo;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type="text")
	private String result;
	
	@Column(nullable=true)
	private String type;
	
//	@JoinColumn(name="htmlInfoId")
//	@OneToMany(cascade=CascadeType.ALL, targetEntity=HtmlAnalysis.class)
//	private List<HtmlAnalysis> htmlAnalysies;
	
	@Column(nullable=false)
	private String htmlInfoId;
	
	@Column(nullable=false)
	private String rId;
	
	@Column(nullable=false)
	private String mId;
	
	@Column(nullable=true)
	private Date createDate;
	
	@Column(nullable=true)
	private Date lastUpdateDate;
	
	@Column(nullable=true, columnDefinition="INT default 1")
	private int status;

	public HtmlAnalysis(String result, String type, String htmlInfoId, String rId, String mId) {
		super();
		this.result = result;
		this.type = type;
		this.htmlInfoId = htmlInfoId;
		this.rId = rId;
		this.mId = mId;
		this.createDate = new Date();
		this.lastUpdateDate = new Date();
	}
	
	
	
}
