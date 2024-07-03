package com.irfan.limitsservice.Entity;

public class LimitConfiguration {
    private int maximum;
    private int minimum;

    public LimitConfiguration(int minimum, int maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }

    protected LimitConfiguration(){

    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
