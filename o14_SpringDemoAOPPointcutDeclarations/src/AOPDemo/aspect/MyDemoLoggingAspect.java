package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//This is where we add all of our related advices for logging
	
	//let's start with @Before advice
	
	//declaring pointcut declaration
	@Pointcut("execution (* AOPDemo.dao.*.*(..))")
	private void forDaoPackage(){}
	
	//applying it to an advice
	@Before("forDaoPackage()") 								
	public void beforeAddAccountAdvice() {
	
		System.out.println("\n=======>>>> Executing @Before advice on method");
		
	}
	
	//reuse on other advice
	@Before("forDaoPackage()") 								
	public void performApiAnalytics() {
		
		System.out.println("=====>>==>> Performing API analytics");
		
	}
}
 