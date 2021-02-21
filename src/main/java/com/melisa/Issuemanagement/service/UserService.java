package com.melisa.Issuemanagement.service;

import com.melisa.Issuemanagement.entity.IssueHistory;
import com.melisa.Issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUserName(String username);
}
