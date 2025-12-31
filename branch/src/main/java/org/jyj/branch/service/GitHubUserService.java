package org.jyj.branch.service;

import org.jyj.branch.model.UserInformation;

public interface GitHubUserService{


     UserInformation getUserInformation(String userId);
}
