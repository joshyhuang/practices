package org.jyj.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GitHubUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubUserApplication.class, args);
    }

}
