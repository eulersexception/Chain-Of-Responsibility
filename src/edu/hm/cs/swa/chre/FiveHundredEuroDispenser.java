package edu.hm.cs.swa.chre;

public class FiveHundredEuroDispenser implements Dispenser {

    private Dispenser nextHandler;

    @Override
    public void setNextHandler(Dispenser nextHandler) {

    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/500) + " bills each 500 Euro");

        nextHandler.dispense(withdrawl%500);
    }
}
