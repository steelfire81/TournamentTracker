package data;

public class Match {

	// Data Members
	private Player winner;
	private Player loser;
	private int winnerPoints; // for planned additions
	private int loserPoints; // for planned additions
	
	// Constructor
	public Match(Player w, Player l)
	{
		winner = w;
		loser = l;
	}
	
	// getWinner
	public Player getWinner()
	{
		return winner;
	}
	
	// getLoser
	public Player getLoser()
	{
		return loser;
	}
	
	// toString
	@Override
	public String toString()
	{
		return winner.getName() + " DEF. " + loser.getName();
	}
}
