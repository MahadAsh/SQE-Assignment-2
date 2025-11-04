package com.example.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("slow")
public class AccountServiceSlowTest {
    AccountService service;
    AccountService.Account acc;

    @BeforeEach
    void setup() {
        service = new AccountService();
        acc = new AccountService.Account("acc1", 1000.0);
    }

    @Test
    void deposit_highVolumeTransactions_maintainsBalance() {
        for (int i = 0; i < 1000; i++) {
            service.deposit(acc, 1.0);
        }
        assertEquals(2000.0, acc.getBalance());
    }

    @Test
    void withdraw_highVolumeTransactions_maintainsBalance() {
        for (int i = 0; i < 100; i++) {
            service.withdraw(acc, 5.0);
        }
        assertEquals(500.0, acc.getBalance());
    }
}
