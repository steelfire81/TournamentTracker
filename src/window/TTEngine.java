package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

import data.Match;
import data.Player;
import data.Tournament;

public class TTEngine implements ActionListener {

	// CONSTANTS - Current Menu
	private static final int MAIN_MENU = 0;
	private static final int PLAYER_PROFILE = 1;
	private static final int PLAYERS_LIST = 2;
	private static final int RATINGS = 3;
	private static final int SEEDING = 4;
	private static final int TOURNAMENT_EDITOR = 5;
	private static final int TOURNAMENT_MANAGER = 6;
	
	// Data Members
	private TTWindow parent;
	private int currentMenu;
	private HashMap<Integer, Player> players;
	private ArrayList<Tournament> tournaments;
	private ArrayList<Match> matches;
	
	// Constructor
	public TTEngine(TTWindow p)
	{
		Player.setComparisonMode(Player.COMPARE_NAME);
		parent = p;
		currentMenu = MAIN_MENU;
		players = new HashMap<Integer, Player>();
		tournaments = new ArrayList<Tournament>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		// Main menu buttons
		if(currentMenu == MAIN_MENU)
		{
			if(source == parent.buttonMMExit)
			{
				exit();
			}
			else if(source == parent.buttonMMLoad)
			{
				
			}
			else if(source == parent.buttonMMRankings)
			{
				currentMenu = RATINGS;
				parent.setFrameToRatingsMenu();
			}
			else if(source == parent.buttonMMRecordTournament)
			{
				currentMenu = TOURNAMENT_MANAGER;
				parent.setFrameToTournamentManager();
			}
			else if(source == parent.buttonMMSave)
			{
				
			}
			else if(source == parent.buttonMMSeedTournament)
			{
				currentMenu = SEEDING;
				parent.setFrameToSeedingMenu();
			}
			else if(source == parent.buttonMMViewPlayers)
			{
				currentMenu = PLAYERS_LIST;
				parent.setFrameToPlayersList();
			}
		}
		// Player profile buttons
		else if(currentMenu == PLAYER_PROFILE)
		{
			if(source == parent.buttonPPBack)
			{
				
			}
			else if(source == parent.buttonPPEdit)
			{
				
			}
		}
		// Players list buttons
		else if(currentMenu == PLAYERS_LIST)
		{
			if(source == parent.buttonPLBack)
			{
				currentMenu = MAIN_MENU;
				parent.setFrameToMainMenu();
			}
			else if(source == parent.buttonPLView)
			{
				
			}
		}
		// Ratings menu buttons
		else if(currentMenu == RATINGS)
		{
			if(source == parent.buttonRMBack)
			{
				currentMenu = MAIN_MENU;
				parent.setFrameToMainMenu();
			}
			else if(source == parent.buttonRMGenerate)
			{
				
			}
		}
		// Seeding menu buttons
		else if(currentMenu == SEEDING)
		{
			if(source == parent.buttonSMBack)
			{
				currentMenu = MAIN_MENU;
				parent.setFrameToMainMenu();
			}
			else if(source == parent.buttonSMPools)
			{
				
			}
			else if(source == parent.buttonSMSeed)
			{
				
			}
		}
		// Tournament editor buttons
		else if(currentMenu == TOURNAMENT_EDITOR)
		{
			if(source == parent.buttonTEAdd)
			{
				if((parent.fieldTEWinner.getText() != null) && (parent.fieldTELoser.getText() != null))
				{
					String winnerName = parent.fieldTEWinner.getText();
					String loserName = parent.fieldTELoser.getText();
					parent.fieldTEWinner.setText("");
					parent.fieldTELoser.setText("");
					addMatch(winnerName, loserName);
				}
			}
			else if(source == parent.buttonTEDelete)
			{
				removeMatch();
			}
			else if(source == parent.buttonTESave)
			{
				if(tournamentReadyToSave())
				{
					saveTournament();
					
					// Trash temporary data
					matches = null;
					DefaultListModel<String> model = (DefaultListModel<String>) parent.listTEMatches.getModel();
					model.removeAllElements();
					
					// Back out to tournament manager menu
					currentMenu = TOURNAMENT_MANAGER;
					parent.setFrameToTournamentManager();
				}
			}
		}
		// Tournament manager buttons
		else if(currentMenu == TOURNAMENT_MANAGER)
		{
			if(source == parent.buttonTMBack)
			{
				currentMenu = MAIN_MENU;
				parent.setFrameToMainMenu();
			}
			else if(source == parent.buttonTMDelete)
			{
				
			}
			else if(source == parent.buttonTMNew)
			{
				matches = new ArrayList<Match>();
				currentMenu = TOURNAMENT_EDITOR;
				parent.setFrameToTournamentEditor();
			}
		}
	}
	
	// MAIN MENU METHODS
	// exit
	private void exit()
	{
		// TODO: Ask to save and save data
		//       Also call this method when window is closed via x button
		System.exit(1);
	}
	
	// TOURNAMENT EDITOR METHODS
	// addMatch
	private void addMatch(String winnerName, String loserName)
	{
		Player winner = players.get(winnerName.hashCode());
		Player loser = players.get(loserName.hashCode());
		
		// Ensure winner and loser actually exist
		if(winner == null)
		{
			winner = new Player(winnerName);
			players.put(winner.getHashcode(), winner);
		}
		if(loser == null)
		{
			loser = new Player(loserName);
			players.put(loser.getHashcode(), loser);
		}
		
		Match newMatch = new Match(winner, loser);
		matches.add(newMatch);
		// NOTE: This method DOES NOT handle updating the winner's/loser's stats
		
		// Update list in window
		DefaultListModel<String> model = (DefaultListModel<String>) parent.listTEMatches.getModel();
		model.addElement(newMatch.toString());
	}
	
	// removeMatch
	private void removeMatch()
	{
		int index = parent.listTEMatches.getSelectedIndex();
		if(index != -1)
		{
			matches.remove(index);
			DefaultListModel<String> model = (DefaultListModel<String>) parent.listTEMatches.getModel();
			model.removeElementAt(index);
		}
	}
	
	// saveTournament
	private void saveTournament()
	{
		ArrayList<Match> handledMatches = new ArrayList<Match>();
		for(int i = 0; i < matches.size(); i++)
		{
			Player winner = matches.get(i).getWinner();
			Player loser = matches.get(i).getLoser();
			winner.recordWin(loser);
			loser.recordWin(winner);
			handledMatches.add(new Match(winner, loser));
		}
		
		int month = Integer.parseInt(parent.fieldTEMonth.getText());
		int day = Integer.parseInt(parent.fieldTEDay.getText());
		int year = Integer.parseInt(parent.fieldTEYear.getText());
		Player first = players.get(parent.fieldTEFirst.getText().hashCode());
		first.setFirstPlaces(first.getFirstPlaces() + 1);
		Player second = players.get(parent.fieldTESecond.getText().hashCode());
		second.setSecondPlaces(second.getSecondPlaces() + 1);
		Player third = players.get(parent.fieldTEThird.getText().hashCode());
		third.setThirdPlaces(third.getThirdPlaces() + 1);
		
		tournaments.add(new Tournament(month, day, year, handledMatches, first, second, third));
	}
	
	// tournamentReadyToSave
	private boolean tournamentReadyToSave()
	{
		if(currentMenu != TOURNAMENT_EDITOR)
			return false;
		if(matches.size() < 1)
			return false;
		if(parent.fieldTEDay.getText() == null)
			return false;
		if(parent.fieldTEMonth.getText() == null)
			return false;
		if(parent.fieldTEYear.getText() == null)
			return false;
		if(parent.fieldTEFirst.getText() == null)
			return false;
		if(parent.fieldTESecond.getText() == null)
			return false;
		if(parent.fieldTEThird.getText() == null)
			return false;
		
		// TODO: Ensure first second & third all played in this tournament
		if(players.get(parent.fieldTEFirst.getText().hashCode()) == null)
			return false;
		if(players.get(parent.fieldTESecond.getText().hashCode()) == null)
			return false;
		if(players.get(parent.fieldTEThird.getText().hashCode()) == null)
			return false;
		
		try
		{
			Integer.parseInt(parent.fieldTEDay.getText());
			Integer.parseInt(parent.fieldTEMonth.getText());
			Integer.parseInt(parent.fieldTEYear.getText());
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		
		return true;
	}
}
