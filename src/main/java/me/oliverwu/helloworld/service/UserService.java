package me.oliverwu.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.oliverwu.helloworld.data.auto.DemoUsersExample;
import me.oliverwu.helloworld.data.auto.DemoUsersMapper;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	DemoUsersMapper demoUserMapper;

	public boolean isUserExisted(String username) {
		DemoUsersExample example = new DemoUsersExample();
		example.or().andUserLoginEqualTo(username);

		int result = demoUserMapper.countByExample(example);
		log.debug("User login: " + username + " count result: " + result);

		return result > 0 ? true : false;
	}

}
