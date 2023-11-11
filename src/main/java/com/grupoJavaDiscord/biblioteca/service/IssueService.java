package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> findAllIssue();
    Issue findIssueById(Long cgender);
    Issue saveIssue(Issue issue);
    Issue updateIssue(Issue issue);
    void deleteIssue(Long cgender);
}
