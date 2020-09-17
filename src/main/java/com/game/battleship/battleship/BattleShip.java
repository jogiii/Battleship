package com.game.battleship.battleship;

public class BattleShip extends  Ship{

    @Override
    public Ship makeShip(String type, int width, int height){
        this.width = width;
        this.height = height;
        this.type = type;
        boolean isShipTypeValid = false;

        if (width < 1 || width > 9) {
            System.out.println("Invalid ship size");

        }
        if (height < 'A'-64 || height > 'Z'-64) {
            System.out.println("Invalid ship size");

        }


        for (ShipType shipType: ShipType.values()) {
            if(shipType.name().equals(type)){
                isShipTypeValid = true;
                break;
            }
        }
        if(!isShipTypeValid){
            System.out.println("Invalid ship type");

        }
        return this;
    }

    @Override
    public int getStrength(String type) {
        return ShipType.valueOf(type).getStrength();
    }
}
