package com.reptilesysem.system.core.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="t_ruleHtmlRef")
public class RuleHtmlInfoRef {
	@Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "uuid")
	private String id;
	
	@Column(nullable=false)
	private String ruleId;
	
	@Column(nullable=false)
	private String htmlInfoId;

	public RuleHtmlInfoRef(String ruleId, String htmlInfoId) {
		super();
		this.ruleId = ruleId;
		this.htmlInfoId = htmlInfoId;
	}
	
}
