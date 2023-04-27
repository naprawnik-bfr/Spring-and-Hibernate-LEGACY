package AOPDemo.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AOPDemo.config.DemoConfig;
import AOPDemo.dao.AccountDAO;
import AOPDemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business methods
		theAccountDAO.addAccount();
		theAccountDAO.doWork();
		
		//call the business method with ONE parameter
		theAccountDAO.addAccount(new Account());
		
		//call the business method with MANY parameter
		theAccountDAO.addAccount(new Account(), true);
		
		//call the membership business method
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}
}
