package com.tr.envanter.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	Integer id;

	@Column(name = "PRODUCT_NAME")
	String name;

	@OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
	private Category category;

	@OneToMany
	@Column(name = "WARE_HOUSE_ID")
	Integer wareHouseId;

	@Column(name = "numberOfProducts")
	Integer numberOfProducts;

	@Column(name = "criticalNumberOfProducts")
	Integer criticalNumberOfProducts;

}
