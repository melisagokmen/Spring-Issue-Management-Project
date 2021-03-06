package com.melisa.Issuemanagement.service;

import com.melisa.Issuemanagement.dto.IssueDto;
import com.melisa.Issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);
}
