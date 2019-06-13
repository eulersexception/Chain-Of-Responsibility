package edu.hm.cs.swa.chre;

import java.util.function.Function;

public class CurrencyDispenser {

    public static Function<CurrencyAmount, CurrencyAmount> handle (int handler) {
        return (amount) -> {
          if(amount.getAmount() >= handler) {
              System.out.println("Dispensing €" + handler + " x " + (amount.getAmount() / handler));
              amount.setAmount(amount.getAmount()%handler);
          }
          return amount;
        };
    }

}
