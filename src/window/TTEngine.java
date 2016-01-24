package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	// Constructor
	public TTEngine(TTWindow p)
	{
		parent = p;
		currentMenu = MAIN_MENU;
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
				
			}
			else if(source == parent.buttonTEDelete)
			{
				
			}
			else if(source == parent.buttonTESave)
			{
				
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
				currentMenu = TOURNAMENT_EDITOR;
				parent.setFrameToTournamentEditor();
			}
		}
	}
	
	// exit - handles closing the program
	private void exit()
	{
		// TODO: Ask to save and save data
		//       Also call this method when window is closed via x button
		System.exit(1);
	}
}
