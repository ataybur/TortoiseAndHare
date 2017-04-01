package com.ataybur;

public class Racer implements Runnable{

	public static String winner;
	
	public void race(){
		for(int distance = 1; distance<= 100; distance++){
			System.out.printf("Distance Covered By %s is %d \n", Thread.currentThread().getName(), distance);
			boolean isRaceWon = isRaceWon(distance);
			if(isRaceWon){
				break;
			}
		}
	}
	
	private boolean isRaceWon(int totalDistanceCovered){
		boolean isRaceWon = false;
		if((Racer.winner == null) && totalDistanceCovered == 100){
			String winnerName = Thread.currentThread().getName();
			Racer.winner = winnerName;
			System.out.printf("Winner is: %s", winnerName);
			isRaceWon = true;
		} else if (Racer.winner == null){
			isRaceWon = false;
		} else if (Racer.winner != null){
			isRaceWon = true;
		}
		return isRaceWon;
	}
	
	@Override
	public void run() {
		this.race();
	}

}
