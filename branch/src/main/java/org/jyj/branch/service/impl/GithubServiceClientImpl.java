package org.jyj.branch.service.impl;


import org.jyj.branch.model.github.GithubRepo;
import org.jyj.branch.model.github.GithubUser;
import org.jyj.branch.service.GithubServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GithubServiceClientImpl implements GithubServiceClient {

    private final RestClient restClient;

    @Autowired
    public GithubServiceClientImpl(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.github.com/users").build();
    }

    @Cacheable(value = "gitHubCache", key = "#userId")
    public GithubUser getGitHubUser(String userId) {
        return this.restClient.get()
                .uri("/{userId}", userId)
                .retrieve()
                .body(GithubUser.class);
    }

    @Cacheable(value = "gitHubRepoCache", key = "#userId")
    public List<GithubRepo> getGitHubUserRepos(String userId) {
        return this.restClient.get()
                .uri("/{userId}/repos", userId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<GithubRepo>>() {
                });
    }
}
