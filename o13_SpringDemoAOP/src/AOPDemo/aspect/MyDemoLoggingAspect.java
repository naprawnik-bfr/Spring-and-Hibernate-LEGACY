package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//This is where we add all of our related advices for logging
	
	//let's start with @Before advice
	
	//------------------------------------------------ MATCH ON METHOD NAME  ----------------------------------------------------------------------------------------------------------
	//	@Before("execution (public void AOPDemo.dao.AccountDAO.addAccount())") 		//(..) -> pointcut expression with fully qualified class name
	//	@Before("execution (public void add*())") 									//(..) -> pointcut expression with wildcard method pattern
	//	@Before("execution (void add*())") 											//(..) -> pointcut expression: deleting optional modifier, with wildcard method pattern
	//	@Before("execution (* add*())") 											//(..) -> pointcut expression with wildcard on return type and method name
	//------------------------------------------------ MATH ON METHOD PARAMETERS --------------------------------------------------------------------------------------------------------
	//	@Before("execution (* add*(AOPDemo.apps.Account))") 						//(..) -> pointcut expression with wildcard on return type and method name for ONE parameter
	//	@Before("execution (* add*(*))") 											//(..) -> pointcut expression with wildcard on return type and method name for ANY BUT ONE parameter
	//	@Before("execution (* add*(AOPDemo.apps.Account, ..))") 					//(..) -> pointcut expression with wildcard on return type and method name for MANY parameter, WITH ONE NAMED
	//	@Before("execution (* add*(..))") 											//(..) -> pointcut expression with wildcard on return type and method name for ANY parameter
	//------------------------------------------------ MATCH ON PACKAGE NAME --------------------------------------------------------------------------------------------------------
		@Before("execution (* AOPDemo.dao.*.*(..))") 								//(..) -> p.e. with w-c on return type and class and method from PACKAGE for ANY parameter
	
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>>>> Executing @Before advice on method");
		
	}
}
 