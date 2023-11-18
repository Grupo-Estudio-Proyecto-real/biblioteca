package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.entity.Loan;
import com.grupoJavaDiscord.biblioteca.service.LoanService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> findAllLoan() {

        return loanService.findAllLoan();
    }

    @GetMapping("/{cloan}")
    @ResponseStatus(HttpStatus.OK)
    public Loan findLoanById(@PathVariable Long cloan) {

        return loanService.findLoanById(cloan);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Loan saveLoan(@RequestBody Loan loan) {

        return loanService.saveLoan(loan);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Loan updateLoan(@RequestBody Loan loan) {

        return loanService.updateLoan(loan);
    }

    @DeleteMapping("/{cloan}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteLoan(@PathVariable Long cloan) {

        loanService.deleteLoan(cloan);
    }
}
