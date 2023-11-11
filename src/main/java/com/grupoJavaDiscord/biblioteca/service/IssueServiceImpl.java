package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService{

    @Autowired
    private IssueRepository issueRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Issue> findAllIssue() {

        return (List<Issue>) issueRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Issue findIssueById(Long cgender) {

        return issueRepository.findById(cgender).orElse(null);
    }

    @Override
    public Issue saveIssue(Issue issue) {

        return issueRepository.save(issue);
    }

    @Override
    public Issue updateIssue(Issue issue) {

        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(Long cgender) {

        issueRepository.deleteById(cgender);
    }
}
