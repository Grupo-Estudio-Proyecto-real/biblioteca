package com.grupoJavaDiscord.biblioteca.repository;


import com.grupoJavaDiscord.biblioteca.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
}
