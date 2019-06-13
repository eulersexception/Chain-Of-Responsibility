package edu.hm.cs.swa.chre;

public class FiveEuroDispenser implements Dispenser {

    private Dispenser nextHandler;

    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int withdrawl) {
        System.out.println((withdrawl/5) + " bills each 5 Euro");

        nextHandler.dispense(withdrawl%5);
    }
}
