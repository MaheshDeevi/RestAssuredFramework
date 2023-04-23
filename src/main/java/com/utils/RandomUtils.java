package com.utils;

public final class RandomUtils {

    private RandomUtils(){}

    //Business Layer --> business level changes
    public static int getId(){
        return FakerUtils.getNumber(1,1000);
    }

    public static String getFirstName(){
        return FakerUtils.getFirstName().toLowerCase();
    }

    public static String getLastName(){
        return FakerUtils.getLastName().toLowerCase();
    }
}
