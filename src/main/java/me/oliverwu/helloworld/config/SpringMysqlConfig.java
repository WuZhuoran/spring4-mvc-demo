package me.oliverwu.helloworld.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import me.oliverwu.helloworld.service.HelloWorldService;
import me.oliverwu.helloworld.service.UserService;

@Configuration
@Import({ LoadPropertiesConfig.class })
@MapperScan(basePackageClasses = { HelloWorldService.class, UserService.class })
public class SpringMysqlConfig {

	public static final String SPRING_MVC_SQL_SESSION_FACTORY = "springmvcSqlSessionFactory";
	
	public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

	@Value("${springmvc.db.url}")
	String springMvcDbUrl;

	@Value("${springmvc.db.user}")
	String springMvcDbUser;

	@Value("${springmvc.db.pass}")
	String springMvcDbPass;

	@Bean
	@Qualifier("springmvc-db")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(COM_MYSQL_JDBC_DRIVER);
		dataSource.setUsername(springMvcDbUser);
		dataSource.setPassword(springMvcDbPass);
		dataSource.setUrl(springMvcDbUrl);

		return dataSource;
	}

	@Bean
	public SqlSessionFactory springmvcSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}
}
