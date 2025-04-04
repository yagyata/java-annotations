package com.bridgelabz.annotations;

import java.util.ArrayList;

public class SuppressUncheckedWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(25);
        list.add("abc");
        System.out.println(list);
    }
}
