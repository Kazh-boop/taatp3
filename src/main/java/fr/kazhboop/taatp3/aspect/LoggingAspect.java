package fr.kazhboop.taatp3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * PointCut to log call on the API
     */
    @Pointcut("within(fr.kazhboop.taatp3.controller.*)")
    public void inRestLayer() {
    }

    /**
     * Inform the start of a method in the rest layer
     * @param joinPoint
     */
    @Before("inRestLayer()")
    public void logMethodStart(JoinPoint joinPoint){
        log.debug("Executing the method " + joinPoint.getSignature());
    }

    /**
     * return the info on the method (do not display info of the DTO)
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "inRestLayer()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.debug("Method " + joinPoint.getSignature().getName() + " terminate" + " result : " + result);
    }
}
