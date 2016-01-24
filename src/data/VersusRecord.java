package data;

public class VersusRecord implements Comparable<VersusRecord> {

	// Data Members
	private Player opponent;
	private int numWins;
	private int numLosses;
	
	// Constructor
	public VersusRecord(Player opp)
	{
		opponent = opp;
		numWins = 0;
		numLosses = 0;
	}
	
	public Player getOpponent()
	{
		return opponent;
	}
	
	public int getNumWins()
	{
		return numWins;
	}
	
	public int getNumLosses()
	{
		return numLosses;
	}
	
	public void setNumWins(int w)
	{
		numWins = w;
	}
	
	public void setNumLosses(int l)
	{
		numLosses = l;
	}
	
	public double getWinPercentage()
	{
		return (double) numWins / ((double) numWins + numLosses);
	}
	
	public int compareTo(VersusRecord other)
	{
		if(getWinPercentage() > other.getWinPercentage())
			return -1;
		else if(getWinPercentage() < other.getWinPercentage())
			return 1;
		else
			return opponent.getName().toUpperCase().compareTo(other.getOpponent().getName().toUpperCase());
	}
}
