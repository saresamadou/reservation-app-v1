package aboudou.samadou.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAspect {
	final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(* aboudou.samadou.services.*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		logger.info("The method " + jp.getClass() + "is calling");
	}
	
	@After("execution(* aboudou.samadou.services.*.*(..))")
	public void afterMethod(JoinPoint jp) {
		logger.info("The method " + jp.getClass() + " has been called");
	}
}
