package co.com.bancolombia.aop;

import co.com.bancolombia.model.kafkaproducer.KafkaProducerRepository;
import co.com.bancolombia.model.log.Log;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class UseCaseAspect {

    private final KafkaProducerRepository kafkaProducer;

    @Before("within(co.com.bancolombia.usecase.user.UserUseCase)")
    public void beforeUserUseCaseMethods(JoinPoint joinPoint) {
        String timestamp = LocalDateTime.now().toString();
        String method = joinPoint.getSignature().getName();
        kafkaProducer.sendMessage(new Log(timestamp, "call method " + method));
    }

    @AfterReturning(pointcut = "execution(* *..UserUseCase.saveUser(..))", returning = "result")
    public void afterSaveUserUseCase(Object result) {
        String timestamp = LocalDateTime.now().toString();
        kafkaProducer.sendMessage(new Log(timestamp, "user save successfully " + result.toString()));
    }

    @After("execution(* *..UserUseCase.deleteUser(..))")
    public void afterDeleteUser(JoinPoint joinPoint) {
        String timestamp = LocalDateTime.now().toString();
        Object userId = joinPoint.getArgs()[0];
        kafkaProducer.sendMessage(new Log(timestamp, "user deleted whit id -> " + userId));
    }

    @AfterThrowing(pointcut = "within(co.com.bancolombia.usecase.user.UserUseCase)", throwing = "ex")
    public void afterTrhowError(JoinPoint joinPoint, Exception ex) {
        String timestamp = LocalDateTime.now().toString();
        String method = joinPoint.getSignature().getName();
        kafkaProducer.sendMessage(new Log(timestamp, "throw error on method " + method + " error -> " + ex.getMessage()));
    }

}
