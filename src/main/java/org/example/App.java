package org.example;

import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String log4jConfPath = "../resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
}
