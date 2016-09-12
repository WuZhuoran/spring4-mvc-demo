package me.oliverwu.helloworld.web.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import me.oliverwu.helloworld.config.SpringMysqlConfig;
import me.oliverwu.helloworld.config.SpringRootConfig;
import me.oliverwu.helloworld.config.SpringWebConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringWebConfig.class, SpringRootConfig.class, SpringMysqlConfig.class })
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void test_welcome() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/hello/oliver")).andExpect(status().isOk()).andReturn();
		
		log.debug("/hello/oliver/ test: " + result.toString());

		MvcResult user = this.mockMvc.perform(get("/user/admin")).andExpect(status().isOk()).andReturn();
		
		log.debug("/user/admin test: " + user.toString());

	}

}