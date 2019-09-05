package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.IbanCode;

/**
 * @author Laxman
 *
 */
@Repository
public interface IbanRepository extends JpaRepository<IbanCode, Integer> {

}
