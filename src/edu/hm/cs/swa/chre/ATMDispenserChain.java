package edu.hm.cs.swa.chre;

import java.util.function.Function;

public class ATMDispenserChain {

    public Function<CurrencyAmount, CurrencyAmount> ATM;

    private Function<CurrencyAmount, CurrencyAmount> handler_500 = CurrencyDispenser.handle(500);
    private Function<CurrencyAmount, CurrencyAmount> handler_200 = CurrencyDispenser.handle(200);
    private Function<CurrencyAmount, CurrencyAmount> handler_100 = CurrencyDispenser.handle(100);
    private Function<CurrencyAmount, CurrencyAmount> handler_50 = CurrencyDispenser.handle(50);
    private Function<CurrencyAmount, CurrencyAmount> handler_20 = CurrencyDispenser.handle(20);
    private Function<CurrencyAmount, CurrencyAmount> handler_10 = CurrencyDispenser.handle(10);
    private Function<CurrencyAmount, CurrencyAmount> handler_5 = CurrencyDispenser.handle(5);

    public ATMDispenserChain() {
                ATM = handler_500
                .andThen(handler_200)
                .andThen(handler_100)
                .andThen(handler_50)
                .andThen(handler_20)
                .andThen(handler_10)
                .andThen(handler_5);
    }
}
