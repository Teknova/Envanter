package com.tr.envanter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WARE_HOUSE")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WARE_HOUSE_ID")
	private Integer wareHouseId;

	@Column(name = "WARE_HOUSE_NAME")
	private String wareHouseName;

	@Column(name = "WARE_HOUSE_ADRESS")
	private String wareHouseAdress;

	@Column(name = "WARE_HOUSE_REGION")
	private String wareHouseRegion;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
}
