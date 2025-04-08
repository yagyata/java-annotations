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

public class MarkImpMethod{
    public static void main(String[] args) {
        Class<?> cls=Tasks.class;
        Method[] methods=cls.getMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod important = method.getAnnotation(ImportantMethod.class);
                if(important.level().equals("HIGH") || important.level().equals("MEDIUM")){
                    try{
                        System.out.println(method.getName());
                        method.invoke(cls.getDeclaredConstructor().newInstance());
                        System.out.println("Importance: " + important.level());
                        System.out.println();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                else{
                    System.out.println(method.getName());
                    System.out.println("Importance: LOW");
                    System.out.println();
                }
            }
        }
    }
}
