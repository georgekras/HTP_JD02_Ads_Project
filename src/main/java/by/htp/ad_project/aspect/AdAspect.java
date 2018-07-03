package by.htp.ad_project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdAspect {

	@Before(value = "execution(* by.htp.ad_project.service.impl.AdServiceImpl.getAllAds(..))")
	public void doSmth() {
		System.out.println("-------------");
		System.out.println("------------------------");
		System.out.println("---------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("Hello my friend!");
	}
	
}
