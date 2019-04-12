package com.reptilesysem.system.core.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_json")
@DynamicInsert
public class EduJsonBean {
	@Id
	private String lemmaId;
	private String lemmaTitle;
	private String lemmaCroppedTitle;
	private String lemmaUrl;
	@Column(nullable=true)
	private String realUrl;
	@Column(nullable=true)
	private String type;
	@Column(nullable=true)
	private String status;
}
