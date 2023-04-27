package AOPDemo.apps;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AOPDemo.config.DemoConfig;
import AOPDemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAcounts = theAccountDAO.findAccounts();
		
		//display the accounts
		System.out.println("\nMain Program: ");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println(theAcounts);
		
		//close the context
		context.close();
	}
}
