package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}

class Tasks{
    @ImportantMethod(level="LOW")
    public void task1(){
        System.out.println("Task1");
    }

    @ImportantMethod(level="MEDIUM")
    public void task2(){
        System.out.println("Task2");
    }

    @ImportantMethod
    public void task3(){
        System.out.println("Task3");
    }
}

public class MarkImportant{
    public static void main(String[] args) {
        Class<?> cls=Tasks.class;
        Method[] methods=cls.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + importantMethod.level());
                System.out.println();
            }
        }
    }
}
