package edu.hm.cs.swa.chre;

public interface Dispenser {

    void setNextHandler(Dispenser nextHandler);

    void dispense(int withdrawl);
}
