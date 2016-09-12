package me.oliverwu.helloworld.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import me.oliverwu.helloworld.data.auto.DemoUsersMapper;
import me.oliverwu.helloworld.service.HelloWorldService;
import me.oliverwu.helloworld.service.UserService;

@Configuration
@Import({ SpringMysqlConfig.class })
@EnableTransactionManagement
@ComponentScan(basePackageClasses = { HelloWorldService.class, UserService.class })
@MapperScan(basePackageClasses = { DemoUsersMapper.class })
public class SpringRootConfig {
}