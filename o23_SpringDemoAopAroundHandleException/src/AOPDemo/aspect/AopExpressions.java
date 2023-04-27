package AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution (* AOPDemo.dao.*.*(..))")
	public void forDaoPackage(){}

	@Pointcut("execution (* AOPDemo.dao.*.get*(..))")
	public void getter(){}

	@Pointcut("execution (* AOPDemo.dao.*.set*(..))")
	public void setter(){}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter(){}
	
}
