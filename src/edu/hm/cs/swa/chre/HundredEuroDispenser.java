package edu.hm.cs.swa.chre;

public class HundredEuroDispenser implements Dispenser {

    private Dispenser nextHandler;


    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;

    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/100) + " bills each 100 Euro");

        nextHandler.dispense(withdrawl%100);
    }
}
