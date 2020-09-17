package com.game.battleship.battleship;

import java.io.PrintStream;

public class BattleArea {
    private int width;
    private char height;
    private Ship [] ship;

    private int area [][];

    private int nextShipPosition = 0;

    public int getTotalStrength() {
        return totalStrength;
    }

    private int totalStrength = 0;

    public Ship[] getShip() {
        return ship;
    }

    public void setShip(Ship[] ship) {
        this.ship = ship;
    }



    public BattleArea(int width, char height){
        this.width = width;
        this.height = height;
        if (width < 1 || width > 9) {
            System.out.println("invalid width");

        }
        if (height < 'A' || height >'Z') {
            System.out.println("invalid height");

        }
        this.area = new int[height - 64][width];
    }

    public Ship[] addShips( int ships){

        this.ship = new Ship[ships];
        return this.ship;
    }

    //A1 x=1 y=A
    public void addShip(Ship ship, String location) {
        this.ship[nextShipPosition++] = ship;
        char yAxis = location.charAt(0);
        int xAxis = Integer.parseInt(location.substring(1));
        if (xAxis < 1 || xAxis > 9) {
            System.out.println("Invalid Ship coordinates");

        }
        if (yAxis < 'A' || yAxis > 'Z') {
            System.out.println("Invalid Ship coordinates");

        }

        for(int i=yAxis-65; i < yAxis-65+ship.getHeight() ; i++){
            for(int j=xAxis-1; j < xAxis-1+ship.getWidth(); j++){
                area[i][j] = ship.getStrength(ship.getType());
                totalStrength += area[i][j];
            }
        }
    }

    public void printBattleArea(PrintStream ps){
        for (int i=0; i<this.getArea().length;i++) {
            for(int j=0; j<this.getArea()[i].length;j++){
                ps.print(this.getArea()[i][j] + " ");
            }
            ps.println("");
        }
    }

    public int damageStrength() {
        return --totalStrength;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char getHeight() {
        return height;
    }

    public void setHeight(char height) {
        this.height = height;
    }


    public int[][] getArea() {
        return area;
    }

    public void setArea(int[][] area) {
        this.area = area;
    }
}
