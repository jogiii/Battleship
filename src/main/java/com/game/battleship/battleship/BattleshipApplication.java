package com.game.battleship.battleship;


import java.io.PrintStream;
import java.util.List;

public class BattleshipApplication {
	Player player1, player2;



	public static void main(String[] args) {
		PrintStream console = System.out;
		if(args.length == 0)
		{
			console.println("please enter full path of input file in command line args");
			System.exit(1);
		}

		List<String> input = FileUtils.readFile(args[0]);
		for (String string : input) {
			console.println(string);
		}

		BattleshipApplication game = new BattleshipApplication();
		game.startGame(input, console);


	}

	public void startGame(List<String> input, PrintStream ps){
		System.out.println(input);
		player1 = new Player("Jogi");
		player2 = new Player("Shubham");
		//get(0) = 5 E contains width and height of battle area
		player1.createBattleArea(input.get(0));
		player2.createBattleArea(input.get(0));

		addPlayersShipsToBattleArea(input);

		player1.addRocket(input.get(input.size()-2));//second last input
		player2.addRocket(input.get(input.size()-1));//last input

		//player1.getBattleArea().printBattleArea(ps);
		//player2.getBattleArea().printBattleArea(ps);

		// PlayGame
		play(ps);
	}

	public void addPlayersShipsToBattleArea(List<String> input){
		// Add totalShips to each battleArea
		int totalShips = new Integer(input.get(1));
		//get(1) =2 total no of ships for both players
		player1.addShipsToBattleArea(totalShips);
		player2.addShipsToBattleArea(totalShips);


		for (int i = 0; i < totalShips; i++) {
			String [] battleShipDetail = input.get(i+2).split(" ");
			//String type, int width, int height, String location
			player1.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[3]);
			player2.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[4]);
		}


	}

	void play(PrintStream ps){

		boolean win = false;
		while(!win){
			//first player 1 start firing
			if(shootUntil(player1, player2, ps)){
				break;
			}

			//then player 2 start firing
			if(shootUntil(player2, player1, ps))
			{
				break;
			}

		}
	}


	private boolean shootUntil(Player playerA, Player playerB, PrintStream ps){
		boolean win = false;
		if(playerA.getRockets().size() == 0){
			ps.println(playerA.getPlayerName() + " has no more missiles left to launch");
		}
		else
		{
			boolean hit = true;
			while(hit && playerA.getRockets().size() > 0){
				hit = playerA.shoot(playerB, ps);
				if(playerB.isDown()){
					ps.println(playerA.getPlayerName() + " won the battle");
					win = true;
					break;
				}
			}
		}
		return win;
	}

}

