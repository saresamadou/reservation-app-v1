package aboudou.samadou.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Class to handle logging cross cutting concern
 * @author absare
 *
 */
@Component
@Aspect
public class LogAspect {
	
	static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	
	/**
	 * Aspect to handle before calling method logging
	 * @param jp to get information from the joinpoint
	 */
	@Before("execution(* aboudou.samadou.services.*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		logger.info("The method " + jp.getClass() + "is calling");
	}
	
	/**Aspect to handle after calling method logging
	 * @param jp to get information from the joinpoint
	 */
	@After("execution(* aboudou.samadou.services.*.*(..))")
	public void afterMethod(JoinPoint jp) {
		logger.info("The method " + jp.getClass() + " has been called");
	}
	
	@After("logWhenCarAlreadyExistExceptionHappens()")
	public void afterCarAlreadyExistsException(JoinPoint jp) {
		logger.info("Exception happen with this info " + jp.getArgs()[0].toString());
	}
	
	/**
	 * Pointcut defintion to log event when a exception of carAlreadyExists happens
	 */
	@Pointcut("execution(void aboudou.samadou.exceptions.CarAlreadyExistsException.CarAlreadyExistsException(String))")
	public void logWhenCarAlreadyExistExceptionHappens() {}
}
