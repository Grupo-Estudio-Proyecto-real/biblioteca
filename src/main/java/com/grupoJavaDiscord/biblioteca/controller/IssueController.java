package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Issue> findAllIssue() {

        return issueService.findAllIssue();
    }

    @GetMapping("/{cgender}")
    @ResponseStatus(HttpStatus.OK)
    public Issue findIssueById(@PathVariable Long cgender) {

        return issueService.findIssueById(cgender);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Issue saveIssue(Issue issue) {

        return issueService.saveIssue(issue);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Issue updateIssue(Issue issue) {

        return issueService.updateIssue(issue);
    }

    @DeleteMapping("/{cgender}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteIssue(@PathVariable Long cgender) {

        issueService.deleteIssue(cgender);
    }

}
