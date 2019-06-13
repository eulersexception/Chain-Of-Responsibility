package edu.hm.cs.swa.chre;

public class TwoHundredEuroDispenser implements Dispenser {

    private Dispenser nextHandler;

    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/200) + " bills each 200 Euro");

        nextHandler.dispense(withdrawl%200);
    }
}
