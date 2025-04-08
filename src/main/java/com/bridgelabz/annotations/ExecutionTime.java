package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

public class ExecutionTime {

    @LogExecutionTime
    public void Task1() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("Task1 executed");
    }

    @LogExecutionTime
    public void Task2() throws InterruptedException {
        Thread.sleep(50);
        System.out.println("Task2 executed");
    }

    public static void main(String[] args) throws Exception {
        ExecutionTime obj = new ExecutionTime();
        Class<?> cls = ExecutionTime.class;

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ns\n");
            }
        }
    }
}
