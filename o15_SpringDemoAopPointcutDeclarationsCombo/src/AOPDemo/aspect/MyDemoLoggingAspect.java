package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	//declaring pointcut declaration for package
	@Pointcut("execution (* AOPDemo.dao.*.*(..))")
	private void forDaoPackage(){}
	
	//declaring pointcut declaration for getters
	@Pointcut("execution (* AOPDemo.dao.*.get*(..))")
	private void getter(){}
	
	//declaring pointcut declaration for setters
	@Pointcut("execution (* AOPDemo.dao.*.set*(..))")
	private void setter(){}
	
	//declaring pointcut declaration: includ package...exclude getters/setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter(){}
	
	//applying it to an advice
	@Before("forDaoPackageNoGetterSetter()") 								
	public void beforeAddAccountAdvice() {
	
		System.out.println("\n=======>>>> Executing @Before advice on method");
		
	}
	
	//reuse on other advice
	@Before("forDaoPackageNoGetterSetter()") 								
	public void performApiAnalytics() {
		
		System.out.println("=====>>==>> Performing API analytics");
		
	}
}
 