package AOPDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import AOPDemo.apps.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	//When we put pointcut declaration in separate class we have to give @Before fully qualified class name.
	
	@Before("AOPDemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") 								
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=======>>>> Executing @Before advice on method");
		
		//display the method signature using join(access) point
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//display method arguments
		
		//get arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru arguments
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				//downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
			
		}
		
	}

}
 