package org.jyj.branch.model;

import org.jyj.branch.model.github.GithubUser;
import org.jyj.branch.service.GitHubUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInformation {

    String user_name;
    String display_name;
    String avatar;
    String geo_location;
    String url;
    String created_at;
    List<UserRepository> repos;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGeo_location() {
        return geo_location;
    }

    public void setGeo_location(String geo_location) {
        this.geo_location = geo_location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<UserRepository> getRepos() {
        return repos;
    }

    public void setRepos(List<UserRepository> repos) {
        this.repos = repos;
    }


    public static UserInformation convert(GithubUser user, Map repos) {
        UserInformation userInformation = null;
        if (user != null) {
            userInformation = new UserInformation();
            userInformation.setUser_name(user.getLogin());
            userInformation.setDisplay_name(user.getName());
            userInformation.setAvatar(user.getAvatar_url());
            userInformation.setGeo_location(user.getLocation());
            userInformation.setCreated_at(user.getCreated_at().toString());
            List<UserRepository> repositories = new ArrayList<>();
            if (repos != null) {
                //
                userInformation.setRepos(repositories);
            }

        }

        return userInformation;
    }
}
