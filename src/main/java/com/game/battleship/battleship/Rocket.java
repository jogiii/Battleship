package com.game.battleship.battleship;

public class Rocket {
    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    private int xAxis;
    private int yAxis;
    String target;

    Rocket(String target){
        this.target = target;
        this.yAxis = target.charAt(0)-65;
        this.xAxis = new Integer(target.substring(1))-1;


    }

    public String getTarget() {
        return target;
    }
    @Override
    public String toString() {
        return target;
    }

}
