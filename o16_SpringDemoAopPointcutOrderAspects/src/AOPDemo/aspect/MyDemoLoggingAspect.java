package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	//When we put pointcut declaration in separate class we have to give @Before fully qualified class name.
	
	@Before("AOPDemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") 								
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>> Executing @Before advice on method");
	}

}
 