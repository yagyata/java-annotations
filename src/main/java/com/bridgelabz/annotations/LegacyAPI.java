package com.bridgelabz.annotations;

public class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Executing the old feature");
    }

    public void newFeature() {
        System.out.println("Executing the new feature");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }

}
