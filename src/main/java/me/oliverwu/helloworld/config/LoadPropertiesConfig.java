package me.oliverwu.helloworld.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class LoadPropertiesConfig {

	private static final String BUS_PROPERTIES_FILE_NAME = "buzConf.properties";

	private static Logger log = LoggerFactory.getLogger(LoadPropertiesConfig.class);

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
		// keep this static
		// the doc said that if you want to use ${} you should make this
		PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();

		String buzConfPath = System.getProperty("buzConfPath");
		String infConfPath = System.getProperty("infConfPath");

		ArrayList<Resource> resources = new ArrayList<>();
		if (infConfPath != null && !infConfPath.isEmpty()) {
			FileSystemResource fileResource = new FileSystemResource(new File(infConfPath));
			resources.add(fileResource);
			log.info("using infConfPath: {}", fileResource);
		} else {
			log.warn("infConfPath is not set");
		}

		if (buzConfPath != null && !buzConfPath.isEmpty()) {
			File confFile = new File(buzConfPath);
			if (confFile.isDirectory()) {
				confFile = new File(buzConfPath, BUS_PROPERTIES_FILE_NAME);
			}
			FileSystemResource fileResource = new FileSystemResource(confFile);
			resources.add(fileResource);
			log.info("using buzConfPath: {}", fileResource);
		} else {
			ClassPathResource classResource = new ClassPathResource(BUS_PROPERTIES_FILE_NAME);
			resources.add(classResource);
			log.info("using buzConfPath: {}", classResource);
		}

		Resource[] res = resources.toArray(new Resource[resources.size()]);
		bean.setLocations(res);

		return bean;
	}
}
