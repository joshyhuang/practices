package org.jyj.branch;

import org.junit.jupiter.api.Test;
import org.jyj.branch.controller.UserController;
import org.jyj.branch.exception.GithubUserNotFoundException;
import org.jyj.branch.model.UserInformation;
import org.jyj.branch.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class GitHubUserApplicationTests {

    @Autowired
    GitHubUserService gitHubUserService;

    @Autowired
    UserController userController;

    @Test
    void testContextLoads() {
        assertNotNull("service initialization error", gitHubUserService);
        assertNotNull("controller initialization error", userController);
    }

    @Test
    void testGetUserInformationNotFound() {
        GithubUserNotFoundException exception = assertThrows(
                GithubUserNotFoundException.class,
                () -> {
                    UserInformation userInformation = gitHubUserService.getUserInformation("NotExistUser");
                }
        );

        assertTrue("User not exist message for 404", exception.getMessage().contains("GitHub user not found"));

    }

    @Test
    void testGetUserInformationOctocat() {

        UserInformation userInformation = gitHubUserService.getUserInformation("octocat");

        assertEquals("User name incorrect", "octocat", userInformation.getUser_name());
        assertEquals("Display name incorrect", "The Octocat", userInformation.getDisplay_name());
        assertEquals("Location incorrect", "San Francisco", userInformation.getGeo_location());
        assertEquals("Url incorrect", "https://api.github.com/users/octocat", userInformation.getUrl());
        assertEquals("Created at field   incorrect", "Tue, 25 Jan 2011 18:44:36 GMT", userInformation.getCreated_at());
        assertTrue ("User has some repos", userInformation.getRepos() != null && !userInformation.getRepos().isEmpty());
        System.out.println(String.format("User information octocat succeeded!  result: %s", userInformation));

    }


}
