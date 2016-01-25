package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Player implements Comparable<Player> {

	// CONSTANTS - Comparison modes
	public static final int COMPARE_NAME = 0;
	public static final int COMPARE_RATING = 1;
	private static final int COMPARE_DEFAULT = COMPARE_NAME;
	
	// Static Data Members
	private static int comparisonMode = COMPARE_NAME;
	
	// Data Members
	private String name;
	private int rating;
	private int wins;
	private int losses;
	private String main;
	private String secondary;
	private HashMap<Integer, VersusRecord> versusRecords;
	
	// Constructor
	public Player(String n)
	{
		name = n;
		
		rating = 0;
		wins = 0;
		losses = 0;
		versusRecords = new HashMap<Integer, VersusRecord>();
	}
	
	// setComparisonMode
	public static void setComparisonMode(int mode)
	{
		if((mode != COMPARE_NAME) && (mode != COMPARE_RATING))
			mode = COMPARE_DEFAULT;
		else
			comparisonMode = mode;
	}
	
	// compareTo
	@Override
	public int compareTo(Player other)
	{
		if(comparisonMode == COMPARE_NAME)
			return name.compareTo(other.getName());
		else // Rating
		{
			if(rating < other.getRating())
				return -1;
			else if(rating > other.getRating())
				return 1;
			else
				return 0;
		}
	}
	
	// getName
	public String getName()
	{
		return name;
	}
	
	// setName
	public void setName(String n)
	{
		name = n;
	}
	
	// getRating
	public int getRating()
	{
		return rating;
	}
	
	// setRating
	public void setRating(int r)
	{
		rating = r;
	}
	
	// getWins
	public int getWins()
	{
		return wins;
	}
	
	// setWins
	public void setWins(int w)
	{
		wins = w;
	}
	
	// getLosses
	public int getLosses()
	{
		return losses;
	}
	
	// setLosses
	public void setLosses(int l)
	{
		losses = l;
	}
	
	// getMain
	public String getMain()
	{
		return main;
	}
	
	// setMain
	public void setMain(String m)
	{
		main = m;
	}
	
	// getSecondary
	public String getSecondary()
	{
		return secondary;
	}
	
	// setSecondary
	public void setSecondary(String s)
	{
		secondary = s;
	}
	
	// getHashcode
	public Integer getHashcode()
	{
		return new Integer(name.hashCode());
	}
	
	// getVersusRecord
	public VersusRecord getVersusRecord(Player p)
	{
		return versusRecords.get(p.getHashcode());
	}
	
	// getAllVersusRecords
	public ArrayList<VersusRecord> getAllVersusRecords()
	{
		ArrayList<VersusRecord> records = new ArrayList<VersusRecord>(versusRecords.values());
		Collections.sort(records);
		return records;
	}
	
	// recordWin
	public void recordWin(Player opponent)
	{
		wins++;
		
		VersusRecord record = versusRecords.get(opponent.getHashcode());
		if(record == null)
		{
			record = new VersusRecord(opponent);
			record.setNumWins(record.getNumWins() + 1);
		}
		else
		{
			record.setNumWins(record.getNumWins() + 1);
		}
	}
	
	// recordLoss
	public void recordLoss(Player opponent)
	{
		losses++;
		
		VersusRecord record = versusRecords.get(opponent.getHashcode());
		if(record == null)
		{
			record = new VersusRecord(opponent);
			record.setNumLosses(record.getNumLosses() + 1);
		}
		else
		{
			record.setNumLosses(record.getNumLosses() + 1);
		}
	}
}