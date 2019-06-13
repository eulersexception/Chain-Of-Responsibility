package edu.hm.cs.swa.chre;

import java.util.Scanner;

public class ATMMachine {

    private static ATMDispenserChain atmDispenserChain;

    public static void main(String[] args) {

        atmDispenserChain = new ATMDispenserChain();

        int amount = 0;
        System.out.println("Enter amount to dispense in € bills");
        Scanner input = new Scanner(System.in);
        amount = input.nextInt();
        if (amount % 5 != 0) {
            System.out.println("Amount should be in multiple of 5s. Dispensing no coins only € bills");
            return;
        }

        atmDispenserChain.ATM.apply(new CurrencyAmount(amount));

    }
}
