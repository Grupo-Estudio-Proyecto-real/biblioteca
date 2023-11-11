package com.grupoJavaDiscord.biblioteca.repository;

import com.grupoJavaDiscord.biblioteca.entity.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {
}
