package edu.hm.cs.swa.chre;

public class TwentyEuroDispenser implements Dispenser {

    private Dispenser nextHandler;


    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;

    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/20) + " bills each 20 Euro");

        nextHandler.dispense(withdrawl%20);
    }
}
