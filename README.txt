# practices
Practice projects

Build and Run

1. mvn clean install
2. mvn spring-boot:run
3. simple unit testing cases included in GitHubUserApplicationTests


API Example

http://localhost:8080/api/github/users/{userId}

1. Not existing user
http://localhost:8080/api/github/users/notexist1234

{"status":404,"message":"GitHub user not found: notexist1234","timestamp":"2026-01-01T00:54:21.980159Z"}


2. Existing user

http://localhost:8080/api/github/users/octocat

{"user_name":"octocat","display_name":"The Octocat","avatar":"https://avatars.githubusercontent.com/u/583231?v=4","geo_location":"San Francisco","url":"https://api.github.com/users/octocat","created_at":"Tue, 25 Jan 2011 18:44:36 GMT","email":null,"repos":[{"name":"boysenberry-repo-1","url":"https://api.github.com/users/octocat"},{"name":"git-consortium","url":"https://api.github.com/users/octocat"},{"name":"hello-worId","url":"https://api.github.com/users/octocat"},{"name":"Hello-World","url":"https://api.github.com/users/octocat"},{"name":"linguist","url":"https://api.github.com/users/octocat"},{"name":"octocat.github.io","url":"https://api.github.com/users/octocat"},{"name":"Spoon-Knife","url":"https://api.github.com/users/octocat"},{"name":"test-repo1","url":"https://api.github.com/users/octocat"}]}



