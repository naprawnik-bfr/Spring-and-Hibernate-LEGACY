package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {
	
	@Before("AOPDemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") 					
	public void loadToCloudAsync() {
		System.out.println("===>>====>> Logging to Cloud in async fashion");
	}
}
