package by.htp.ad_project.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdAspect {

	private static final Logger logger = LogManager.getLogger();

	@Before("execution(* by.htp.ad_project.service.impl.**.*(..))")
	private void logMethodNameWithArgs(JoinPoint joinpoint) {
		logger.info("---Before advice--- " + "ServiceName = " + joinpoint.getTarget().getClass().getSimpleName() + " | " + "methodName = "
				+ joinpoint.getSignature().getName() + " | " + "args = " + Arrays.asList(joinpoint.getArgs()));
	}

	@After("execution(* by.htp.ad_project.service.impl.**.*(..))")
	private void logAfter(JoinPoint joinpoint) {
		logger.info("---After advice--- " + "ServiceName = " + joinpoint.getTarget().getClass().getSimpleName() + " | " + "methodName = "
				+ joinpoint.getSignature().getName() + " | " + "args = " + Arrays.asList(joinpoint.getArgs()));
	}
	
}
