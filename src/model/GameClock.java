package model;

//importing Calendar library
import java.util.Calendar;

/**
 *
 * GameClock is a class that keeps track of game time.
 * Methods return minutes and seconds remaining for
 * continue feature, returns a string of the remaining time
 * for the games map view, and is checked for for game over if the
 * player goes over the 20 minute time limit (for current build). 
 * 
*/

public class GameClock {
	
	//total end time in seconds
	private  int endTimeInSeconds;
	
	//game timer constants
	private  final int TIMELIMIT = 20;
	private  final int HOURCONV = 3600, MINCONV = 60;

	/**
	 * The isGameOver method checks if the player has exceded the time limit that has been put on the game.
	 * This is so that we can end the game when the user takes too long to complete it.
	 * 
	 * @return boolean true if game is over 
	 */
	public  boolean isGameOver() {
		 int currentTimeInSeconds = getTimeInSeconds();
		 boolean gameOver = true;
		 if (currentTimeInSeconds < endTimeInSeconds)
			 gameOver = false;
		 return gameOver;
	}	
	

	/** 
	 * The getTimer method is a getter which gets our "timer".
	 * It returns a string time in "00:00" format for the game's map view.
	 * 
	 * @return String of time remaining 
	 */
	public  String getTimer()	{
		String remainingTime = "";
		int minutesRemaining = getMinutesRemaining();
		int secondsRemaining = getSecondsRemaining();		

		String mRemaining = String.format("%02d", minutesRemaining);
		String sRemaining = String.format("%02d", secondsRemaining);
		remainingTime =  mRemaining + ":" + sRemaining;

		return remainingTime;
	}
	
	/**
	 * The getMinutesRemaining method is a getter method which returns minutes remaining for saving the game
	 * and works as helper method for getTimer().
	 * 
	 * @return integer of minutes remaining
	 */
	public  int getMinutesRemaining()	{
		int currentTimeInSeconds = getTimeInSeconds();
		int timeRemaining = endTimeInSeconds - currentTimeInSeconds;
		int minutesRemaining = timeRemaining / MINCONV;
		
		return minutesRemaining;
	}
	
	/**
	 * getSecondsRemaining returns seconds remaining for saving game and works as a helper
	 * method for getTimer().
	 * 
	 * @return integer of remaining seconds
	 */
	public  int getSecondsRemaining()	{
		int currentTimeInSeconds = getTimeInSeconds();
		int timeRemaining = endTimeInSeconds - currentTimeInSeconds;
		int secondsRemaining = timeRemaining % MINCONV;	
		
		return secondsRemaining;
	}
	
	/** 
	 * getHoursRemaining is a method which returns the hours remaining 
	 * for the user to complete the game if it is needed in the future.
	 * 
	 * @return hours remaining
	 */
	public  int getHoursRemaining()	{
		int currentTimeInSeconds = getTimeInSeconds();
		int timeRemaining = endTimeInSeconds - currentTimeInSeconds;
		int hoursRemaining = timeRemaining / HOURCONV;	
		
		return hoursRemaining;
	}
	
	/**
	 * getTimeInSeconds is a private helper method to get time in seconds for calculations
	 * in other methods.
	 * 
	 * @return integer of all time remaining in seconds 
	 */
	private  int getTimeInSeconds() {
		Calendar currentTime = Calendar.getInstance();
		int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
		int currentMinute = currentTime.get(Calendar.MINUTE);
		int currentSecond = currentTime.get(Calendar.SECOND);
		int currentTimeInSeconds = (currentHour * HOURCONV) + (currentMinute * MINCONV) + currentSecond;
		return currentTimeInSeconds;
	}
	
	/** 
	 * setTimeReamining is a public method
	 * it is a setter to set the time remaining when loading from saved game.
	 * 
	 * @param minutes integer that represents minutes remaining from save file
	 * @param seconds integer that represents seconds remaining from save file
	 */
	public void setTimeRemaining(int minutes, int seconds) {
		endTimeInSeconds = (minutes * MINCONV) + seconds + getTimeInSeconds();	
	}
	
	/**
	 * resetTime is a public method that resets the game clock to zero when starting a new game.
	 * It calculates the end time in seconds using the current time and the time limit.
	 */
	public void resetTime() {
		int currentTimeInSeconds = getTimeInSeconds();
		endTimeInSeconds = currentTimeInSeconds + (TIMELIMIT * MINCONV);
	}
	
}
