package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Loan;
import com.grupoJavaDiscord.biblioteca.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepository loanRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Loan> findAllLoan() {

        return (List<Loan>) loanRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Loan findLoanById(Long cloan) {

        return loanRepository.findById(cloan).orElse(null);
    }

    @Override
    public Loan saveLoan(Loan loan) {

        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoan(Loan loan) {

        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long cloan) {

        loanRepository.deleteById(cloan);
    }
}
