package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.dto.IssueAdminDTO;
import com.grupoJavaDiscord.biblioteca.exception.IssueNotFoundException;
import com.grupoJavaDiscord.biblioteca.exception.IssueNotSaveException;
import com.grupoJavaDiscord.biblioteca.service.IssueAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/issue")
@RequiredArgsConstructor
public class IssueAdminController {

    private final IssueAdminService issueAdminService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<IssueAdminDTO> findAllIssue() {

        List<IssueAdminDTO> issueAdminDTOS = issueAdminService.findAllIssue();

        if (issueAdminDTOS.isEmpty()) {
            throw new IssueNotFoundException("(Controller) - No issues found, the list is empty.");
        }

        return issueAdminDTOS;
    }

    @GetMapping("/{cgender}")
    @ResponseStatus(HttpStatus.OK)
    public IssueAdminDTO findIssueById(@PathVariable Long cgender) {

        Optional<IssueAdminDTO> issue = Optional.ofNullable(issueAdminService.findIssueById(cgender));

        if (issue.isPresent()) {
            return issue.get();
        } else {
            throw new IssueNotFoundException("(Controller) - Issue with id is not found " + cgender);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public IssueAdminDTO saveIssue(@RequestBody @Valid IssueAdminDTO issueAdminDTO) {

        try {
                return issueAdminService.saveIssue(issueAdminDTO);
        } catch (IssueNotSaveException e) {
            throw new IssueNotSaveException("(Controller) - Issue can´t create correctly");
        }
    }

    @PutMapping("/{cgender}")
    @ResponseStatus(HttpStatus.OK)
    public IssueAdminDTO updateIssue(@RequestBody @Valid IssueAdminDTO issueAdminDTO, @PathVariable Long cgender) {

        Optional<IssueAdminDTO> existingAdminIssue = Optional.ofNullable(issueAdminService.findIssueById(cgender));

        try {
            if (existingAdminIssue.isEmpty()) {
                throw new IssueNotFoundException("(Controller) - Issue with id is not found " + cgender);
            }

            return issueAdminService.updateIssue(issueAdminDTO, cgender);
        } catch (IssueNotSaveException e) {
            throw new IssueNotSaveException("(Controller) - Issue can´t update correctly");
        }
    }

    @DeleteMapping("/{cgender}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteIssue(@PathVariable Long cgender) {

        Optional<IssueAdminDTO> existingAdminDTO = Optional.ofNullable(issueAdminService.findIssueById(cgender));

        if (existingAdminDTO.isEmpty()) {
            throw new IssueNotFoundException("(Controller) - Issue with id is not found " + cgender);
        }

        issueAdminService.deleteIssue(cgender);
    }
}
