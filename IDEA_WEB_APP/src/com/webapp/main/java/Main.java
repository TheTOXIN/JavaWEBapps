package com.webapp.main.java;

public class Main {
    public static String getHello() {
        String res = "COOL WEB APP \\('o')/ №";
        int r = (int) (Math.random() * 100);
        res += r;
        if (r < 10)
            res = "ДОТЫКАЛСЯ";
        return res;
    }
}
