package org.jyj.branch.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepo {
    private String name;
    private GithubOwner owner;

    public String getName() {
        return name;
    }

    public GithubOwner getOwner() {
        return owner;
    }
}

