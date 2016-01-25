package data;

import java.util.ArrayList;

public class Tournament implements Comparable<Tournament> {

	// DATA MEMBERS
	private int month;
	private int day;
	private int year;
	private Player first;
	private Player second;
	private Player third;
	private ArrayList<Match> matchList;
	
	// Constructor
	public Tournament(int m, int d, int y, ArrayList<Match> matches)
	{
		month = m;
		day = d;
		year = y;
		matchList = matches;
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
