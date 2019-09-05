package com.ing.bank.entity;

import javax.persistence.Entity;
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

	private Integer ibanId;
	private Integer ibanCode;
	private String bankName;
	
}
