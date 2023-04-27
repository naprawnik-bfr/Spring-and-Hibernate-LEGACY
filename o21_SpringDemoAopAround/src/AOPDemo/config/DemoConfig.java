package AOPDemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration				//pure java configuration annotation
@EnableAspectJAutoProxy		//Spring AOP Proxy Support
@ComponentScan ("AOPDemo")	//Component scan for components and aspects -> Recurse packages
public class DemoConfig {
}
