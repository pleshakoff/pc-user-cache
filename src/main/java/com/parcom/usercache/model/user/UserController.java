package com.parcom.usercache.model.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/users",produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(tags="Users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by ID")
    public User getMyUser(@PathVariable Long id)  {
        return userService.getById(id);
    }

    @DeleteMapping("/reset/{id}")
    @ApiOperation(value = "Get user by ID")
    public void delete(@PathVariable Long id)  {
        userService.delete(id);
    }

    @DeleteMapping("/reset/all")
    @ApiOperation(value = "Get user by ID")
    public void deleteAll(@PathVariable Long id)  {
        userService.deleteAll();
    }

}
