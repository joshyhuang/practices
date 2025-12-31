package org.jyj.branch.service.impl;

import org.jyj.branch.exception.GithubApiException;
import org.jyj.branch.exception.GithubUserNotFoundException;
import org.jyj.branch.model.UserInformation;
import org.jyj.branch.model.github.GithubRepo;
import org.jyj.branch.model.github.GithubUser;
import org.jyj.branch.service.GitHubUserService;
import org.jyj.branch.service.GithubServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class GithubServiceImpl implements GitHubUserService {

    private GithubServiceClient client;

    @Override
    public UserInformation getUserInformation(String userId) {

        try {
            GithubUser githubUser = client.getGitHubUser(userId);
            if (githubUser != null) {
                List<GithubRepo> userRepos = client.getGitHubUserRepos(userId);
                UserInformation userInformation = UserInformation.convert(githubUser, userRepos);
                return userInformation;

            }
        } catch (HttpClientErrorException.NotFound ex) {
            throw new GithubUserNotFoundException(userId);
        } catch (Exception ex) {
            throw new GithubApiException("Failed to fetch GitHub user", ex);
        }
        return null;
    }


    @Autowired
    public GithubServiceImpl(GithubServiceClient client) {
        this.client = client;
    }


}
