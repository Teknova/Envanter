package com.tr.envanter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCT_HISTORY")
public class ProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HISTORY_ID")
	private Integer historyId;

	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "PROCESS_DATE")
	private Date processDate;

	@Column(name = "PROCESS_TYPE")
	private String processType;

	@Column(name = "USER_INFO")
	private String userInfo;

}
