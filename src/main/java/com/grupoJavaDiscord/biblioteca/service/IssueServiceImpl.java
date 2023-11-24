package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.IssueDTO;
import com.grupoJavaDiscord.biblioteca.dto.map.MapToDTO;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.exception.IssueNotFoundException;
import com.grupoJavaDiscord.biblioteca.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService{

    @Autowired
    private IssueRepository issueRepository;

    @Override
    @Transactional(readOnly = true)
    public List<IssueDTO> findAllIssue() {

        List<Issue> issues = (List<Issue>) issueRepository.findAll();

        return issues.stream()
                .map(MapToDTO::mapIssueToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public IssueDTO findIssueById(Long cgender) {

        Optional<Issue> existingIssue = issueRepository.findById(cgender);

        return existingIssue.map(MapToDTO::mapIssueToDTO)
                .orElseThrow(() -> new IssueNotFoundException(" Issue not found because this id no exist"));
    }

    @Override
    public IssueDTO saveIssue(IssueDTO issueDTO) {

        Issue issue = Issue.builder()
                .issue(issueDTO.getIssue())
                .subtopic(issueDTO.getSubtopic())
                .build();

        return MapToDTO.mapIssueToDTO(issueRepository.save(issue));
    }

    @Override
    public IssueDTO updateIssue(IssueDTO issueDTO, Long cgender) {

        Optional<Issue> existingIssue = issueRepository.findById(cgender);

        Issue issue = existingIssue.orElse(null);

        issue.setIssue(issueDTO.getIssue());
        issue.setSubtopic(issueDTO.getSubtopic());

        return MapToDTO.mapIssueToDTO(issueRepository.save(issue));
    }

    @Override
    public void deleteIssue(Long cgender) {

        issueRepository.deleteById(cgender);
    }
}
