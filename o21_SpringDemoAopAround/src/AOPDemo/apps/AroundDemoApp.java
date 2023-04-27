package AOPDemo.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AOPDemo.config.DemoConfig;
import AOPDemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
				
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("calling getFortune");
		
		String data = theFortuneService.getFortune(); 
		
		System.out.println("\nMy fortune is: " + data);
	
		System.out.println("Finished");
		
		//close the context
		context.close();
	}
}
