package AOPDemo.apps;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AOPDemo.config.DemoConfig;
import AOPDemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		
		List<Account> theAcounts = null;
	
		try {
			
			//add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAcounts = theAccountDAO.findAccounts(tripWire);
			
		}catch (Exception exc) {
			
			System.out.println("\nMain program... caught exception: " + exc);
			
		}
		
		//display the accounts
		System.out.println("\nMain Program: AfterThrowingDemoApp");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println(theAcounts);
		
		//close the context
		context.close();
	}
}
