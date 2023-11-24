package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.dto.IssueDTO;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.exception.IssueNotFoundException;
import com.grupoJavaDiscord.biblioteca.service.IssueService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<IssueDTO> findAllIssue() {

        List<IssueDTO> issueDTOS = issueService.findAllIssue();

        if (issueDTOS.isEmpty()) {
            throw new IssueNotFoundException("No issues found, the list is empty.");
        }
        return issueDTOS;
    }

    @GetMapping("/{cgender}")
    @ResponseStatus(HttpStatus.OK)
    public IssueDTO findIssueById(@PathVariable Long cgender) {

        Optional<IssueDTO> issue = Optional.ofNullable(issueService.findIssueById(cgender));

        if (issue.isPresent()) {
            return issue.get();
        } else {
            throw new IssueNotFoundException("Book with id is not found " + cgender);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public IssueDTO saveIssue(@RequestBody @Valid IssueDTO issueDTO) {

        try {
            return issueService.saveIssue(issueDTO);
        } catch (IssueNotFoundException e) {
            throw new IssueNotFoundException("Issue can´t create correctly");
        }
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public IssueDTO updateIssue(@RequestBody @Valid IssueDTO issueDTO, Long cgender) {

        Optional<IssueDTO> existingIssue = Optional.ofNullable(issueService.findIssueById(cgender));

        try {
             if (existingIssue.isEmpty()) {
                 throw new IssueNotFoundException("Issue with id is not found " + cgender);
             }
            return issueService.updateIssue(issueDTO, cgender);

        } catch (IssueNotFoundException e) {
            throw new IssueNotFoundException("Issue can´t update correctly");
        }
    }

    @DeleteMapping("/{cgender}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteIssue(@PathVariable Long cgender) {

        Optional<IssueDTO> existingUser = Optional.ofNullable(issueService.findIssueById(cgender));

        if (existingUser.isEmpty()) {
            throw new IssueNotFoundException("Issue with id is not found " + cgender);
        }

        issueService.deleteIssue(cgender);
    }

}
