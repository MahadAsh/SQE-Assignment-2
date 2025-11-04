package com.example.app;

public class Calculator {
    public double add(double a, double b){ return a + b; }
    public double subtract(double a, double b){ return a - b; }
    public double multiply(double a, double b){ return a * b; }
    public double divide(double a, double b){
        if(b == 0) throw new IllegalArgumentException("division by zero");
        return a / b;
    }
    public long factorial(int n){
        if(n < 0) throw new IllegalArgumentException("negative");
        long res = 1;
        for(int i=2;i<=n;i++) res *= i;
        return res;
    }
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
    public double sqrt(double a) {
        if(a < 0) throw new IllegalArgumentException("negative");
        return Math.sqrt(a);
    }
}
