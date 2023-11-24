package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.IssueDTO;
import com.grupoJavaDiscord.biblioteca.entity.Issue;

import java.util.List;

public interface IssueService {

    List<IssueDTO> findAllIssue();
    IssueDTO findIssueById(Long cgender);
    IssueDTO saveIssue(IssueDTO issueDTO);
    IssueDTO updateIssue(IssueDTO issueDTO, Long cgender);
    void deleteIssue(Long cgender);
}
