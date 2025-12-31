package org.jyj.branch.controller;

import org.jyj.branch.model.UserInformation;
import org.jyj.branch.service.GitHubUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
public class UserController {

    GitHubUserService gitHubUserService;

    public UserController(GitHubUserService gitHubUserService) {
        this.gitHubUserService = gitHubUserService;
    }

    @GetMapping("/users/{userid}")
    public UserInformation getUserInformation(@PathVariable("userid") String userId) {

        UserInformation userInformation = gitHubUserService.getUserInformation(userId);
        return userInformation;

    }


}
