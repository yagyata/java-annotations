package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

class Bug {
    @BugReport(description = "Bug 1")
    @BugReport(description = "Bug 2")
    public void display() {
        System.out.println("Printing bug");
    }

    @BugReport(description = "Bug 3")
    public void check() {
        System.out.println("Check");
    }
}


public class RepeatableAnnotation {
    public static void main(String[] args) {
        Class<?> cls = Bug.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports report = method.getAnnotation(BugReports.class);

                for (BugReport bug : report.value()) {
                    try {
                        System.out.println(method.getName());
                        method.invoke(cls.getDeclaredConstructor().newInstance());
                        System.out.println(bug.description());
                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } else if (method.isAnnotationPresent(BugReport.class)) {
                BugReport bug = method.getAnnotation(BugReport.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Bug description :" + bug.description());
                System.out.println();

            }
        }
    }
}
