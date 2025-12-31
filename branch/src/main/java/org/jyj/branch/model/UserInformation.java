package org.jyj.branch.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jyj.branch.JsonUtil;
import org.jyj.branch.model.github.GithubRepo;
import org.jyj.branch.model.github.GithubUser;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class UserInformation {

    String user_name;
    String display_name;
    String avatar;
    String geo_location;
    String url;
    String created_at;
    String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRepository> getRepos() {
        return repos;
    }

    public void setRepos(List<UserRepository> repos) {
        this.repos = repos;
    }


    public static UserInformation convert(GithubUser user, List<GithubRepo> repos) {
        UserInformation userInformation = null;
        if (user != null) {
            userInformation = new UserInformation();
            userInformation.setUser_name(user.getLogin());
            userInformation.setDisplay_name(user.getName());
            userInformation.setAvatar(user.getAvatar_url());
            userInformation.setUrl(user.getUrl());
            userInformation.setGeo_location(user.getLocation());
            userInformation.setEmail(user.getEmail());
            if (user.getCreated_at() != null) {
                String formatDate = user.getCreated_at().format(DateTimeFormatter.RFC_1123_DATE_TIME);
                userInformation.setCreated_at(formatDate);
            }

            List<UserRepository> repositories = new ArrayList<>();
            if (repos != null) {
                for (GithubRepo repo : repos) {
                    repositories.add(new UserRepository(repo.getName(), repo.getOwner().getUrl()));
                }
                userInformation.setRepos(repositories);
            }

        }

        return userInformation;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this, true);
    }
}
