package org.jyj.branch.controller;

import org.jyj.branch.model.UserInformation;
import org.jyj.branch.service.GitHubUserService;
import org.jyj.branch.service.impl.GithubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    GitHubUserService gitHubUserService;

    public UserController(GitHubUserService gitHubUserService) {
        this.gitHubUserService = gitHubUserService;
    }

    @GetMapping
    public UserInformation getUserInformation(@PathVariable String userId) {

        return new UserInformation();

    }
}
