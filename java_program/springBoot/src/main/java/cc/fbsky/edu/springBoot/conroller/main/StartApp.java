package cc.fbsky.edu.springBoot.conroller.main;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartApp
{
	static final Logger LOG = LoggerFactory.getLogger(StartApp.class);
	
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(StartApp.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx)
	{
		return args ->
		{
			LOG.debug("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames)
			{
				LOG.debug(beanName);
			}
		};
	}
	
}
