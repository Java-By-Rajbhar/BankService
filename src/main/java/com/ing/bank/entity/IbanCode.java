package com.ing.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 *
 */
@Getter
@Setter
@Entity
@Table
public class IbanCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ibanId;
	private Integer ibanCode;
	private String bankName;
	
}
