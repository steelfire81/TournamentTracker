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
		
	}

}
