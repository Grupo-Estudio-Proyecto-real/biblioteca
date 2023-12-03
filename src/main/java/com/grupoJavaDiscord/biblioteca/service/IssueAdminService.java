package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.IssueAdminDTO;

import java.util.List;

public interface IssueAdminService {

    List<IssueAdminDTO> findAllIssue();
    IssueAdminDTO findIssueById(Long cgender);
    IssueAdminDTO saveIssue(IssueAdminDTO issueAdminDTO);
    IssueAdminDTO updateIssue(IssueAdminDTO issueAdminDTO, Long cgender);
    void deleteIssue(Long cgender);
}
