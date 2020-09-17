package com.game.battleship.battleship;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

    private String playerName;
    BattleArea battleArea;

    Queue<Rocket> rockets = new LinkedList<Rocket>();
    Player(String name){
        this.playerName=name;
    }

    public BattleArea createBattleArea(String battleAreaDimensions){

        String [] dimensions = battleAreaDimensions.split(" ");
        battleArea = new BattleArea(new Integer(dimensions[0]), dimensions[1].charAt(0));

        return battleArea;
    }

    public BattleArea getBattleArea() {

        return battleArea;
    }

    public Ship[] addShipsToBattleArea(int totalShips){
        // Add totalShips to each battleArea
        return battleArea.addShips(totalShips);
    }

    public void addShipInBattleArea(String type, int width, int height, String location){

        // Add different type of ships to each battleArea
        Ship ship = new BattleShip();
        ship = ship.makeShip(type, width, height);

        // Update ship location
        battleArea.addShip(ship, location);
    }

    public void addRocket(String input){
        for (String target : input.split(" ")) {
            Rocket m = new Rocket(target);
            rockets.add(m);
        }
    }

    public boolean shoot(Player player, PrintStream ps){
        boolean hit = false;
        Rocket rocket = rockets.remove();
        int value = player.getBattleArea().getArea()[rocket.getyAxis()][rocket.getxAxis()];
        if(value == 0)
        {
            ps.println(playerName + " fires a missile with target " + rocket.getTarget() + " which got miss");
        }
        else
        {
            ps.println(playerName + " fires a missile with target " + rocket.getTarget() + " which got hit");
            player.getBattleArea().getArea()[rocket.getyAxis()][rocket.getxAxis()] = player.getBattleArea().getArea()[rocket.getyAxis()][rocket.getxAxis()] - 1;
            player.getBattleArea().damageStrength();
            hit = true;
        }
        return hit;
    }

    public boolean isDown(){
        return (battleArea.getTotalStrength() == 0) ? true : false;
    }

    public Queue<Rocket> getRockets() {
        return rockets;
    }

    public String getPlayerName() {
        return playerName;
    }


}
