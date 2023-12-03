package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.IssueAdminDTO;
import com.grupoJavaDiscord.biblioteca.dto.map.MapToDTO;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.exception.IssueNotFoundException;
import com.grupoJavaDiscord.biblioteca.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueAdminServiceImpl implements IssueAdminService {

    private final IssueRepository issueRepository;

    @Override
    @Transactional(readOnly = true)
    public List<IssueAdminDTO> findAllIssue() {

        List<Issue> issues =  (List<Issue>) issueRepository.findAll();

        return issues.stream()
                .map(MapToDTO::mapIssueAdminToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public IssueAdminDTO findIssueById(Long cgender) {

        Optional<Issue> existingIssue = issueRepository.findById(cgender);

        return existingIssue.map(MapToDTO::mapIssueAdminToDTO)
                .orElseThrow( () -> new IssueNotFoundException("Issue not found because this id no exist"));
    }

    @Override
    public IssueAdminDTO saveIssue(IssueAdminDTO issueAdminDTO) {

        Issue issue = Issue.builder()
                .issue(issueAdminDTO.getIssue())
                .subtopic(issueAdminDTO.getSubtopic())
                .build();

        return MapToDTO.mapIssueAdminToDTO(issueRepository.save(issue));
    }

    @Override
    public IssueAdminDTO updateIssue(IssueAdminDTO issueAdminDTO, Long cgender) {

        Optional<Issue> existingIssue = issueRepository.findById(cgender);

        Issue issue = existingIssue.orElse(null);

        issue.setIssue(issueAdminDTO.getIssue());
        issue.setSubtopic(issueAdminDTO.getSubtopic());

        return MapToDTO.mapIssueAdminToDTO(issueRepository.save(issue));
    }

    @Override
    public void deleteIssue(Long cgender) {

        Optional<Issue> existingIssue = issueRepository.findById(cgender);

        Issue issue = existingIssue.orElseThrow( ()-> new IssueNotFoundException("Issues not found because this id no exist"));

        issueRepository.deleteById(cgender);
    }
}
