package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Loan;
import java.util.List;

public interface LoanService {

    List<Loan> findAllLoan();
    Loan findLoanById(Long cloan);
    Loan saveLoan(Loan loan);
    Loan updateLoan(Loan loan);
    void deleteLoan(Long cloan);
}
