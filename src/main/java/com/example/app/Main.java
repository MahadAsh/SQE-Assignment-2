package com.example.app;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Calculator: 2 + 3 = " + calc.add(2, 3));
        System.out.println("Calculator: 5 / 2 = " + calc.divide(5, 2));
        System.out.println("Calculator: Factorial(5) = " + calc.factorial(5));

        AccountService service = new AccountService();
        AccountService.Account acc = new AccountService.Account("acc1", 100.0);
        service.deposit(acc, 50);
        System.out.println("AccountService: Balance = " + acc.getBalance());

        System.out.println("StringUtils: Reverse 'hello' = " + StringUtils.reverse("hello"));
        System.out.println("StringUtils: Is 'racecar' palindrome? " + StringUtils.isPalindrome("racecar"));
    }
}
