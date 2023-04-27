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
		
		//call the business method with MANY parameter
		theAccountDAO.addAccount(new Account(), true);
		theAccountDAO.doWork();
		
		//call the account DAO getter/setter methods
		theAccountDAO.setName("LOLO");
		theAccountDAO.setServiceCode("987t6gybhji8u");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		//call the membership business method
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}
}
