package edu.hm.cs.swa.chre;

public class TenEuroDispenser implements Dispenser {

    private Dispenser nextHandler;


    @Override
    public void setNextHandler(Dispenser nextHandler) {
        this.nextHandler = nextHandler;

    }

    @Override
    public void dispense(int withdrawl) {

        System.out.println((withdrawl/10) + " bills each 10 Euro");

        nextHandler.dispense(withdrawl%10);
    }
}
