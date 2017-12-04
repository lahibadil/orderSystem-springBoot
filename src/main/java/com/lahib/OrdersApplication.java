package com.lahib;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class OrdersApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrdersApplication.class, args);

		log.info("---> App Name => " +ctx.getApplicationName());
		log.info("---> App Dispaly name => " +ctx.getDisplayName());
		log.info("========== Beans ==========");
		for (String bean: ctx.getBeanDefinitionNames()){
			log.info("\t" + bean.toString());
		}
		log.info("===========================");



	}
}
