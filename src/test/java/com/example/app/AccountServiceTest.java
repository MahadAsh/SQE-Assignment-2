package com.example.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    AccountService service;
    AccountService.Account acc;

    @BeforeEach
    void setup(){
        service = new AccountService();
        acc = new AccountService.Account("acc1", 100.0);
    }

    @Test @Tag("fast")
    void deposit_positiveIncreasesBalance(){ service.deposit(acc, 50); assertEquals(150, acc.getBalance()); }

    @Test @Tag("fast")
    void deposit_nonPositive_throws(){ assertThrows(IllegalArgumentException.class, ()->service.deposit(acc, 0)); }

    @Test @Tag("fast")
    void withdraw_validReducesBalance(){ service.withdraw(acc, 40); assertEquals(60, acc.getBalance()); }

    @Test @Tag("fast")
    void withdraw_insufficientFunds_throws(){ assertThrows(IllegalStateException.class, ()->service.withdraw(acc, 200)); }

    @Test @Tag("fast")
    void withdraw_nonPositive_throws(){ assertThrows(IllegalArgumentException.class, ()->service.withdraw(acc, -1)); }

    @Test @Tag("fast")
    void deposit_smallAmount_increasesBalance() {
        service.deposit(acc, 0.01);
        assertEquals(100.01, acc.getBalance());
    }

    @Test @Tag("fast")
    void withdraw_toZeroBalance_succeeds() {
        service.withdraw(acc, 100.0);
        assertEquals(0.0, acc.getBalance());
    }
}
