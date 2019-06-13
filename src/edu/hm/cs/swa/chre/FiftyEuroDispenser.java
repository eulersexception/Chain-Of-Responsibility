package edu.hm.cs.swa.chre;

public class FiftyEuroDispenser implements Dispenser {

    private Dispenser nextHandler;


    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;

    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/50) + " bills each 50 Euro");

        nextHandler.dispense(withdrawl%50);
    }
}
