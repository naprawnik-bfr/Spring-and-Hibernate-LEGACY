package AOPDemo.apps;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AOPDemo.config.DemoConfig;
import AOPDemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

//---------------------------------------------Setting up logger----------------------------------------------
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
//------------------------------------------------------------------------------------------------------------	
			
	public static void main(String[] args) {
			
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
				
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("calling getFortune");
		
		String data = theFortuneService.getFortune(); 
		
		myLogger.info("\nMy fortune is: " + data);
	
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}
}
