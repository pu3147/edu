package cc.fbsky.edu.springBoot.conroller.main;

import org.springframework.boot.SpringApplication;

import cc.fbsky.edu.springBoot.conroller.HelloController;

public class StartApp
{
	public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}
