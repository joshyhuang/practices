package org.jyj.branch.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubOwner {
    private String url;

    public String getUrl() {
        return url;
    }
}
