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
@Table(name="t_moudleHtmlRef")
public class MoudleHtmlInfoRef {
	@Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "uuid")
	private String id;
	
	@Column(nullable=false)
	private String htmlInfoId;
	
	@Column(nullable=false)
	private String moudleId;
	
	public MoudleHtmlInfoRef(String htmlInfoId, String moudleId) {
		super();
		this.htmlInfoId = htmlInfoId;
		this.moudleId = moudleId;
	}
}
