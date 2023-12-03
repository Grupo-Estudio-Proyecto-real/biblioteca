package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.LoanAdminDTO;

import java.util.List;

public interface LoanAdminService {

    List<LoanAdminDTO> findAllLoan();
    LoanAdminDTO findLoanById(Long cloan);
    LoanAdminDTO saveLoan(LoanAdminDTO loanAdminDTO);
    LoanAdminDTO updateLoan(LoanAdminDTO loanAdminDTO, Long cloan);
    void deleteLoan(Long cloan);
}
