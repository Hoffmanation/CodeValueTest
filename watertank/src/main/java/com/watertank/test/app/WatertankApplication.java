package com.watertank.test.app;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.watertank.test.daoImp.WatertankFacade;
import com.watertank.test.entity.WatertankWrapper;

@ServletComponentScan
@EnableAutoConfiguration
@ComponentScan({ "com.watertank.test.entity", "com.watertank.test.rest", "com.watertank.test.daoImp",
		"com.watertank.test.app" })
@EnableConfigurationProperties(WatertankWrapper.class)
@SpringBootApplication
@PropertySource("classpath:application.properties")

public class WatertankApplication implements CommandLineRunner {

	@Value("${test.watertanks.container2}")
	public String initWatertanksContainers;
	
	public int port = 8080;

	@Autowired
	private WatertankFacade watertankFacade;

	public static void main(String[] args) {
		SpringApplication.run(WatertankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Please uncomment the blow when running as a spring boot web app (java -jar)
		
		/*
		while (true) {
			for (String watertankId : initWatertanksContainers.split(",")) {

				Random r = new Random();
				long randomeLiter = r.nextInt((10 - 2) + 1) + 2;
				System.out.println("New test for : " + watertankId);
				System.out.println(watertankFacade.getQueryMaxCapacity(watertankId,port));
				System.out.println(watertankFacade.getQueryCurrentCapacity(watertankId,port));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(watertankFacade.addWater(watertankId, randomeLiter,port));
				System.out.println(watertankFacade.getQueryCurrentCapacity(watertankId,port));
				System.out.println("Finished\n");
			}

		}*/

	}

}