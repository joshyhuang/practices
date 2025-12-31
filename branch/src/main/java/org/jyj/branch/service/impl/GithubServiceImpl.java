package org.jyj.branch.service.impl;

import org.jyj.branch.model.UserInformation;
import org.jyj.branch.model.github.GithubUser;
import org.jyj.branch.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class GithubServiceImpl implements GitHubUserService {
    @Override
    public UserInformation getUserInformation(String userId) {
        GithubUser githubUser = getGitHubUser(userId);

        if (githubUser != null) {
           Map userRepos =  getGitHubUserRepos(userId);
           UserInformation userInformation = UserInformation.convert(githubUser, userRepos);
           return userInformation;

        }
        return null;
    }

    private final RestClient restClient;

    @Autowired
    public GithubServiceImpl(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.github.com/users").build();
    }

    private GithubUser getGitHubUser(String userId) {
        return this.restClient.get()
                .uri("/{userId}", userId)
                .retrieve()
                .body(GithubUser.class); // Automatically converts JSON response to a Java object
    }


    private Map getGitHubUserRepos(String userId) {
        return this.restClient.get()
                .uri("/{userId}", userId)
                .retrieve()
                .body(HashMap.class); // Automatically converts JSON response to a Java object
    }

}
