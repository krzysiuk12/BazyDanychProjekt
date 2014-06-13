package pl.edu.agh.tutorial.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Krzysiu on 2014-06-03.
 */
@Aspect
public class PerformanceAspect {

    @Around("execution(* pl.edu.agh.tutorial.performanceTest.ComplexQueriesTest.*(..))")
    public Object performTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("**********************************************");
        System.out.println("Current Method: " + proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        System.out.println("Start Time: " + start);
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End Time: " + end);
        System.out.println("Time in millis: " + (end - start));
        System.out.println("**********************************************");
        return object;
    }

}
