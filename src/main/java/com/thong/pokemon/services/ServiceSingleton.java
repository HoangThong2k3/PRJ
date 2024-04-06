package com.thong.pokemon.services;

public class ServiceSingleton {

    private static UserService userServiceInstance;

    private ServiceSingleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized UserService getUserServiceInstance() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

}
