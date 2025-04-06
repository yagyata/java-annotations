package com.bridgelabz.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Yagyata")
    void task1() {
        System.out.println("Task 1 Completed");
    }

    @TaskInfo(priority = "Low", assignedTo = "Yagyata")
    void task2() {
        System.out.println("Task 2 Completed");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) {
        Class<?> c = TaskManager.class;

        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo info = method.getAnnotation(TaskInfo.class);
                System.out.println("Method Name: " + method.getName());
                System.out.println("Priority: " + info.priority());
                System.out.println("Assigned To: " + info.assignedTo());
                System.out.println();
            }
        }
    }
}
