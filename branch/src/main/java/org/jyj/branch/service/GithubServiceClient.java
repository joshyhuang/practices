package org.jyj.branch.service;

import org.jyj.branch.model.github.GithubRepo;
import org.jyj.branch.model.github.GithubUser;

import java.util.List;

public interface GithubServiceClient {

    GithubUser getGitHubUser(String userId);
    List<GithubRepo> getGitHubUserRepos(String userId);
}
