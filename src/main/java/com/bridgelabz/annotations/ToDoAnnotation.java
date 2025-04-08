package com.bridgelabz.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
    String status() default "Pending";
}

class Task {
    @Todo(task = "Complete Annotation topic", assignedTo = "Yagyata", priority = "Medium", status = "Completed")
    public void completeWork() {
        System.out.println("Completing the work");
    }

    @Todo(task = "Shopping List", assignedTo = "Loveleen", priority = "Low")
    public void groceryShopping(){
        System.out.println("Buy milk, eggs, bread, and cheese");
    }

    @Todo(task = "Pay Bills", assignedTo = "Riya")
    public void Errands(){
        System.out.println("Pay bills online");
    }
}

public class ToDoAnnotation {
    public static void main(String[] args) {
        Class<?> c = Task.class;
        Method[] methods = c.getMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(Todo.class)) {
                Todo td = method.getAnnotation(Todo.class);
                if(td.status().equals("Pending")) {
                    System.out.println("PENDING TASK");
                    System.out.println(td.task());
                    System.out.println(td.assignedTo());
                    System.out.println(td.priority());
                    System.out.println();
                }
            }
        }
    }
}
