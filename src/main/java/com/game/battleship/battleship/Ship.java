package com.game.battleship.battleship;

public abstract class Ship {
    int width;
    int height;
    String type;

    public abstract Ship makeShip(String type, int width, int height);
    public abstract int getStrength(String type);

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
