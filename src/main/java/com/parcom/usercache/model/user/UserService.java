package com.parcom.usercache.model.user;

import org.springframework.security.access.annotation.Secured;

public interface UserService {

    @Secured({"ROLE_ADMIN","ROLE_MEMBER"})
    User getById(Long id);

    void delete(Long id);

    void deleteAll();
}
