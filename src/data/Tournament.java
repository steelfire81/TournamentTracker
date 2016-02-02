package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Tournament implements Comparable<Tournament> {

	// DATA MEMBERS
	private int month;
	private int day;
	private int year;
	private Player first;
	private Player second;
	private Player third;
	private ArrayList<Match> matchList;
	private HashMap<Integer, Player> players;
	
	// Constructor
	public Tournament(int m, int d, int y, ArrayList<Match> matches, Player f, Player s, Player t)
	{
		month = m;
		day = d;
		year = y;
		matchList = matches;
		first = f;
		second = s;
		third = t;
		players = new HashMap<Integer, Player>();
	}
	
	// getMonth
	public int getMonth()
	{
		return month;
	}
	
	// getDay
	public int getDay()
	{
		return day;
	}
	
	// getYear
	public int getYear()
	{
		return year;
	}
	
	// getMatches
	public ArrayList<Match> getMatches()
	{
		return matchList;
	}
	
	// setMatches
	public void setMatches(ArrayList<Match> matches)
	{
		matchList = matches;
		for(int i = 0; i < matches.size(); i++)
		{
			Player winner = matches.get(i).getWinner();
			Player loser = matches.get(i).getLoser();
			
			if(players.get(winner.getHashcode()) == null)
				players.put(winner.getHashcode(), winner);
			
			if(players.get(loser.getHashcode()) == null)
				players.put(loser.getHashcode(), loser);
		}
	}
	
	// getFirst
	public Player getFirst()
	{
		return first;
	}
	
	// setFirst
	public void setFirst(Player f)
	{
		first = f;
	}
	
	// getSecond
	public Player getSecond()
	{
		return second;
	}
	
	// setSecond
	public void setSecond(Player s)
	{
		second = s;
	}
	
	// getThird
	public Player getThird()
	{
		return third;
	}
	
	// setThird
	public void setThird(Player t)
	{
		third = t;
	}
	
	// compareTo
	@Override
	public int compareTo(Tournament other)
	{
		return toString().compareTo(other.toString()); // convenient workaround
	}
	
	// toString
	@Override
	public String toString()
	{
		return year + "-" + month + "-" + day;
	}
}
