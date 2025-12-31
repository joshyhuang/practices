package org.jyj.branch;

import org.junit.jupiter.api.Test;
import org.jyj.branch.controller.UserController;
import org.jyj.branch.model.UserInformation;
import org.jyj.branch.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class GitHubUserApplicationTests {

    @Autowired
    GitHubUserService gitHubUserService;

    @Autowired
    UserController userController;

    @Test
    void testContextLoads() {
        assertNotNull("service initialization error",  gitHubUserService);
        assertNotNull("controller initialization error",  userController);
    }

    @Test
    void testGetUserInformation() {
        HttpClientErrorException exception = assertThrows(
                HttpClientErrorException.class,
                () -> {
                    UserInformation userInformation = gitHubUserService.getUserInformation("NotExistUser");
                }
        );

        assertTrue("User not exist message for 404", exception.getMessage().contains("404 Not Found"));

    }

}
