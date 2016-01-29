package window;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TTWindow {

	// Constants - Meta
	private static final String META_VERSION = "v0.0.1";
	
	// Window Elements - Frame and Panels
	JFrame frame;
	JPanel panelMainMenu;
	JPanel panelSeedTournament;
	JPanel panelTournamentManager;
	JPanel panelTournamentEditor;
	JPanel panelPlayersList;
	JPanel panelPlayerProfile;
	JPanel panelRatings;
	
	// Elements - Main Menu
	private static final String TITLE_MAIN_MENU = "Main Menu";
	private static final int WIDTH_MAIN_MENU = 300;
	private static final int HEIGHT_MAIN_MENU = 300;
	private static final String LABEL_MAIN_MENU = "steelfire's Tourney Tracker";
	JButton buttonMMSeedTournament;
	private static final String BUTTON_MM_SEED_TEXT = "Seed New Tournament";
	JButton buttonMMRecordTournament;
	private static final String BUTTON_MM_RECORD_TEXT = "Record Tournament";
	JButton buttonMMViewPlayers;
	private static final String BUTTON_MM_PLAYERS_TEXT = "View Player Database";
	JButton buttonMMRankings;
	private static final String BUTTON_MM_RANKINGS_TEXT = "View Rankings";
	JButton buttonMMLoad;
	private static final String BUTTON_MM_LOAD_TEXT = "LOAD";
	JButton buttonMMSave;
	private static final String BUTTON_MM_SAVE_TEXT = "SAVE";
	JButton buttonMMExit;
	private static final String BUTTON_MM_EXIT_TEXT = "EXIT";
	
	// Elements - Seeding Menu
	private static final String TITLE_SEEDING_MENU = "Seed Tournament";
	private static final int WIDTH_SEEDING_MENU = 600;
	private static final int HEIGHT_SEEDING_MENU = 400;
	JButton buttonSMBack;
	private static final String BUTTON_SM_BACK_TEXT = "MAIN MENU";
	JButton buttonSMSeed;
	private static final String BUTTON_SM_SEED_TEXT = "SEED PLAYERS >>>";
	JButton buttonSMPools;
	private static final String BUTTON_SM_POOLS_TEXT = "PUT INTO POOLS >>>";
	private static final String LABEL_SM_POOL_SIZE = "Pool Size:";
	JTextField fieldSMPoolSize;
	JTextArea areaSMPlayers;
	JTextArea areaSMResults;
	
	// Elements - Tournament Management Menu
	private static final String TITLE_TOURNAMENT_MANAGER = "Tournament Manager";
	private static final int WIDTH_TOURNAMENT_MANAGER = 500;
	private static final int HEIGHT_TOURNAMENT_MANAGER = 300;
	JButton buttonTMBack;
	private static final String BUTTON_TM_BACK_TEXT = "MAIN MENU";
	JButton buttonTMNew;
	private static final String BUTTON_TM_NEW_TEXT = "New";
	JButton buttonTMDelete;
	private static final String BUTTON_TM_DELETE_TEXT = "Delete";
	JList<String> listTMTournaments;
	
	// Elements - Tournament Editor Menu
	private static final String TITLE_TOURNAMENT_EDITOR = "Tournament Editor";
	private static final int WIDTH_TOURNAMENT_EDITOR = 670;
	private static final int HEIGHT_TOURNAMENT_EDITOR = 300;
	private static final String LABEL_TE_WINNER = "Winner:";
	private static final String LABEL_TE_LOSER = "Loser:";
	private static final String LABEL_TE_DATE = "MM/DD/YYYY";
	private static final String LABEL_TE_FIRST = "1st:";
	private static final String LABEL_TE_SECOND = "2nd:";
	private static final String LABEL_TE_THIRD = "3rd:";
	JButton buttonTESave;
	private static final String BUTTON_TE_SAVE_TEXT = "SAVE";
	JButton buttonTEAdd;
	private static final String BUTTON_TE_ADD_TEXT = "Add Game";
	JButton buttonTEDelete;
	private static final String BUTTON_TE_DELETE_TEXT = "Delete Game";
	JTextField fieldTEWinner;
	JTextField fieldTELoser;
	JTextField fieldTEMonth;
	JTextField fieldTEDay;
	JTextField fieldTEYear;
	JTextField fieldTEFirst;
	JTextField fieldTESecond;
	JTextField fieldTEThird;
	JList<String> listTEMatches;
	
	// Elements - Players List
	private static final String TITLE_PLAYERS_LIST = "Players";
	private static final int WIDTH_PLAYERS_LIST = 500;
	private static final int HEIGHT_PLAYERS_LIST = 300;
	JButton buttonPLBack;
	private static final String BUTTON_PL_BACK_TEXT = "MAIN MENU";
	JButton buttonPLView;
	private static final String BUTTON_PL_VIEW_TEXT = "View Selected Player's Profile";
	JList<String> listPLPlayers;
	
	// Elements - Player Profile
	private static final String TITLE_PLAYER_PROFILE = "Profile";
	private static final int WIDTH_PLAYER_PROFILE = 500;
	private static final int HEIGHT_PLAYER_PROFILE = 300;
	private static final String LABEL_PP_RATING = "Rating:";
	private static final String LABEL_PP_RECORD = "Record (W-L):";
	private static final String LABEL_PP_MAIN = "Main:";
	private static final String LABEL_PP_SECONDARY = "Secondary:";
	private static final String LABEL_PP_DETAILED_RECORD = "Detailed Record:";
	JButton buttonPPBack;
	private static final String BUTTON_PP_BACK_TEXT = "BACK";
	JButton buttonPPEdit;
	private static final String BUTTON_PP_EDIT_TEXT = "TOGGLE EDIT";
	JTextField fieldPPName;
	JTextField fieldPPRating;
	JTextField fieldPPRecord;
	JTextField fieldPPMain;
	JTextField fieldPPSecondary;
	JTextArea areaPPDetailedRecord;
	
	// Elements - Ratings Menu
	private static final String TITLE_RATINGS_MENU = "Ratings";
	private static final int WIDTH_RATINGS_MENU = 500;
	private static final int HEIGHT_RATINGS_MENU = 300;
	JButton buttonRMBack;
	private static final String BUTTON_RM_BACK_TEXT = "MAIN MENU";
	JButton buttonRMGenerate;
	private static final String BUTTON_RM_GENERATE_TEXT = "Generate";
	JTextArea areaRMRatings;
	
	// Constructor
	public TTWindow()
	{
		// Initialize Engine
		TTEngine engine = new TTEngine(this);
		
		// Initialize Main Menu
		panelMainMenu = new JPanel(new GridLayout(8, 1));
		JTextField labelMainMenu = new JTextField(LABEL_MAIN_MENU + " " + META_VERSION);
		labelMainMenu.setEditable(false);
		labelMainMenu.setHorizontalAlignment(JTextField.CENTER);
		buttonMMSeedTournament = new JButton(BUTTON_MM_SEED_TEXT);
		buttonMMRecordTournament = new JButton(BUTTON_MM_RECORD_TEXT);
		buttonMMViewPlayers = new JButton(BUTTON_MM_PLAYERS_TEXT);
		buttonMMRankings = new JButton(BUTTON_MM_RANKINGS_TEXT);
		buttonMMLoad = new JButton(BUTTON_MM_LOAD_TEXT);
		buttonMMSave = new JButton(BUTTON_MM_SAVE_TEXT);
		buttonMMExit = new JButton(BUTTON_MM_EXIT_TEXT);
		buttonMMSeedTournament.addActionListener(engine);
		buttonMMRecordTournament.addActionListener(engine);
		buttonMMViewPlayers.addActionListener(engine);
		buttonMMRankings.addActionListener(engine);
		buttonMMLoad.addActionListener(engine);
		buttonMMSave.addActionListener(engine);
		buttonMMExit.addActionListener(engine);
		panelMainMenu.add(labelMainMenu);
		panelMainMenu.add(buttonMMSeedTournament);
		panelMainMenu.add(buttonMMRecordTournament);
		panelMainMenu.add(buttonMMViewPlayers);
		panelMainMenu.add(buttonMMRankings);
		panelMainMenu.add(buttonMMLoad);
		panelMainMenu.add(buttonMMSave);
		panelMainMenu.add(buttonMMExit);
		
		// Initialize Seeding Menu
		panelSeedTournament = new JPanel(new BorderLayout());
		JPanel panelSMSubpanel = new JPanel(new GridLayout(1, 3));
		JPanel panelSMButtons = new JPanel(new GridLayout(3, 1));
		JPanel panelSMPoolSize = new JPanel(new GridLayout(1, 2));
		buttonSMBack = new JButton(BUTTON_SM_BACK_TEXT);
		buttonSMSeed = new JButton(BUTTON_SM_SEED_TEXT);
		buttonSMPools = new JButton(BUTTON_SM_POOLS_TEXT);
		areaSMPlayers = new JTextArea();
		areaSMResults = new JTextArea();
		areaSMResults.setEditable(false);
		JScrollPane paneSMPlayers = new JScrollPane(areaSMPlayers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane paneSMResults = new JScrollPane(areaSMResults, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextField labelSMPoolSize = new JTextField(LABEL_SM_POOL_SIZE);
		labelSMPoolSize.setEditable(false);
		fieldSMPoolSize = new JTextField();
		buttonSMBack.addActionListener(engine);
		buttonSMSeed.addActionListener(engine);
		buttonSMPools.addActionListener(engine);
		panelSMPoolSize.add(labelSMPoolSize);
		panelSMPoolSize.add(fieldSMPoolSize);
		panelSMButtons.add(buttonSMSeed);
		panelSMButtons.add(buttonSMPools);
		panelSMButtons.add(panelSMPoolSize);
		panelSMSubpanel.add(paneSMPlayers);
		panelSMSubpanel.add(panelSMButtons);
		panelSMSubpanel.add(paneSMResults);
		panelSeedTournament.add(buttonSMBack, BorderLayout.NORTH);
		panelSeedTournament.add(panelSMSubpanel, BorderLayout.CENTER);
		
		// Initialize Tournament Management Menu
		panelTournamentManager = new JPanel(new GridLayout(1, 2));
		JPanel panelTMButtons = new JPanel(new GridLayout(3, 1));
		buttonTMBack = new JButton(BUTTON_TM_BACK_TEXT);
		buttonTMNew = new JButton(BUTTON_TM_NEW_TEXT);
		buttonTMDelete = new JButton(BUTTON_TM_DELETE_TEXT);
		listTMTournaments = new JList<String>(new DefaultListModel<String>());
		listTMTournaments.setLayoutOrientation(JList.VERTICAL);
		JScrollPane paneTMList = new JScrollPane(listTMTournaments, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonTMBack.addActionListener(engine);
		buttonTMNew.addActionListener(engine);
		buttonTMDelete.addActionListener(engine);
		panelTMButtons.add(buttonTMBack);
		panelTMButtons.add(buttonTMNew);
		panelTMButtons.add(buttonTMDelete);
		panelTournamentManager.add(paneTMList);
		panelTournamentManager.add(panelTMButtons);
		
		// Initialize Tournament Editor Menu
		panelTournamentEditor = new JPanel(new BorderLayout());
		JPanel panelTEMatchInput = new JPanel(new GridLayout(1, 6));
		JPanel panelTEAdditionalInfo = new JPanel(new GridLayout(8, 1));
		JPanel panelTEDate = new JPanel(new GridLayout(1, 3));
		buttonTESave = new JButton(BUTTON_TE_SAVE_TEXT);
		buttonTEAdd = new JButton(BUTTON_TE_ADD_TEXT);
		buttonTEDelete = new JButton(BUTTON_TE_DELETE_TEXT);
		JTextField labelTEWinner = new JTextField(LABEL_TE_WINNER);
		labelTEWinner.setEditable(false);
		fieldTEWinner = new JTextField();
		JTextField labelTELoser = new JTextField(LABEL_TE_LOSER);
		labelTELoser.setEditable(false);
		fieldTELoser = new JTextField();
		JTextField labelTEDate = new JTextField(LABEL_TE_DATE);
		labelTEDate.setEditable(false);
		fieldTEMonth = new JTextField();
		fieldTEDay = new JTextField();
		fieldTEYear = new JTextField();
		JTextField labelTEFirst = new JTextField(LABEL_TE_FIRST);
		labelTEFirst.setEditable(false);
		fieldTEFirst = new JTextField();
		JTextField labelTESecond = new JTextField(LABEL_TE_SECOND);
		labelTESecond.setEditable(false);
		fieldTESecond = new JTextField();
		JTextField labelTEThird = new JTextField(LABEL_TE_THIRD);
		labelTEThird.setEditable(false);
		fieldTEThird = new JTextField();
		listTEMatches = new JList<String>(new DefaultListModel<String>());
		listTEMatches.setLayoutOrientation(JList.VERTICAL);
		JScrollPane paneTEList = new JScrollPane(listTEMatches, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonTESave.addActionListener(engine);
		buttonTEAdd.addActionListener(engine);
		buttonTEDelete.addActionListener(engine);
		panelTEDate.add(fieldTEMonth);
		panelTEDate.add(fieldTEDay);
		panelTEDate.add(fieldTEYear);
		panelTEAdditionalInfo.add(labelTEDate);
		panelTEAdditionalInfo.add(panelTEDate);
		panelTEAdditionalInfo.add(labelTEFirst);
		panelTEAdditionalInfo.add(fieldTEFirst);
		panelTEAdditionalInfo.add(labelTESecond);
		panelTEAdditionalInfo.add(fieldTESecond);
		panelTEAdditionalInfo.add(labelTEThird);
		panelTEAdditionalInfo.add(fieldTEThird);
		panelTEMatchInput.add(labelTEWinner);
		panelTEMatchInput.add(fieldTEWinner);
		panelTEMatchInput.add(labelTELoser);
		panelTEMatchInput.add(fieldTELoser);
		panelTEMatchInput.add(buttonTEAdd);
		panelTEMatchInput.add(buttonTEDelete);
		panelTournamentEditor.add(buttonTESave, BorderLayout.NORTH);
		panelTournamentEditor.add(paneTEList, BorderLayout.CENTER);
		panelTournamentEditor.add(panelTEAdditionalInfo, BorderLayout.EAST);
		panelTournamentEditor.add(panelTEMatchInput, BorderLayout.SOUTH);
		
		// Initialize Players List
		panelPlayersList = new JPanel(new BorderLayout());
		buttonPLBack = new JButton(BUTTON_PL_BACK_TEXT);
		buttonPLView = new JButton(BUTTON_PL_VIEW_TEXT);
		listPLPlayers = new JList<String>(new DefaultListModel<String>());
		listPLPlayers.setLayoutOrientation(JList.VERTICAL);
		JScrollPane panePLList = new JScrollPane(listPLPlayers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonPLBack.addActionListener(engine);
		buttonPLView.addActionListener(engine);
		panelPlayersList.add(buttonPLBack, BorderLayout.NORTH);
		panelPlayersList.add(panePLList, BorderLayout.CENTER);
		panelPlayersList.add(buttonPLView, BorderLayout.SOUTH);
		
		// Initialize Player Profile Menu
		panelPlayerProfile = new JPanel(new BorderLayout());
		JPanel panelPPButtons = new JPanel(new GridLayout(1, 2));
		JPanel panelPPData = new JPanel(new GridLayout(1, 2));
		JPanel panelPPStats = new JPanel(new GridLayout(5, 1));
		JPanel panelPPRating = new JPanel(new GridLayout(1, 2));
		JPanel panelPPRecord = new JPanel(new GridLayout(1, 2));
		JPanel panelPPMain = new JPanel(new GridLayout(1, 2));
		JPanel panelPPSecondary = new JPanel(new GridLayout(1, 2));
		JPanel panelPPDetailedRecord = new JPanel(new BorderLayout());
		buttonPPBack = new JButton(BUTTON_PP_BACK_TEXT);
		buttonPPEdit = new JButton(BUTTON_PP_EDIT_TEXT);
		fieldPPName = new JTextField();
		fieldPPName.setEditable(false);
		JTextField labelPPRating = new JTextField(LABEL_PP_RATING);
		labelPPRating.setEditable(false);
		fieldPPRating = new JTextField();
		fieldPPRating.setEditable(false);
		JTextField labelPPRecord = new JTextField(LABEL_PP_RECORD);
		labelPPRecord.setEditable(false);
		fieldPPRecord = new JTextField();
		fieldPPRecord.setEditable(false);
		JTextField labelPPMain = new JTextField(LABEL_PP_MAIN);
		labelPPMain.setEditable(false);
		fieldPPMain = new JTextField();
		fieldPPMain.setEditable(false);
		JTextField labelPPSecondary = new JTextField(LABEL_PP_SECONDARY);
		labelPPSecondary.setEditable(false);
		fieldPPSecondary = new JTextField();
		fieldPPSecondary.setEditable(false);
		JTextField labelPPDetailedRecord = new JTextField(LABEL_PP_DETAILED_RECORD);
		labelPPDetailedRecord.setEditable(false);
		areaPPDetailedRecord = new JTextArea();
		areaPPDetailedRecord.setEditable(false);
		JScrollPane panePPDetailedRecord = new JScrollPane(areaPPDetailedRecord, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonPPEdit.addActionListener(engine);
		buttonPPBack.addActionListener(engine);
		panelPPRating.add(labelPPRating);
		panelPPRating.add(fieldPPRating);
		panelPPRecord.add(labelPPRecord);
		panelPPRecord.add(fieldPPRecord);
		panelPPMain.add(labelPPMain);
		panelPPMain.add(fieldPPMain);
		panelPPSecondary.add(labelPPSecondary);
		panelPPSecondary.add(fieldPPSecondary);
		panelPPStats.add(fieldPPName);
		panelPPStats.add(panelPPRating);
		panelPPStats.add(panelPPRecord);
		panelPPStats.add(panelPPMain);
		panelPPStats.add(panelPPSecondary);
		panelPPData.add(panelPPStats);
		panelPPDetailedRecord.add(labelPPDetailedRecord, BorderLayout.NORTH);
		panelPPDetailedRecord.add(panePPDetailedRecord, BorderLayout.CENTER);
		panelPPData.add(panelPPDetailedRecord);
		panelPPButtons.add(buttonPPEdit);
		panelPPButtons.add(buttonPPBack);
		panelPlayerProfile.add(panelPPData, BorderLayout.CENTER);
		panelPlayerProfile.add(panelPPButtons, BorderLayout.SOUTH);
		
		// Initialize Ratings Menu
		panelRatings = new JPanel(new BorderLayout());
		JPanel panelRMButtons = new JPanel(new GridLayout(1, 2));
		buttonRMBack = new JButton(BUTTON_RM_BACK_TEXT);
		buttonRMGenerate = new JButton(BUTTON_RM_GENERATE_TEXT);
		areaRMRatings = new JTextArea();
		areaRMRatings.setEditable(false);
		JScrollPane paneRMRatings = new JScrollPane(areaRMRatings, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonRMBack.addActionListener(engine);
		buttonRMGenerate.addActionListener(engine);
		panelRMButtons.add(buttonRMBack);
		panelRMButtons.add(buttonRMGenerate);
		panelRatings.add(panelRMButtons, BorderLayout.NORTH);
		panelRatings.add(paneRMRatings, BorderLayout.CENTER);
		
		// Make the main menu visible
		frame = new JFrame("");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFrameToMainMenu();
	}
	
	// setFrameToMainMenu
	public void setFrameToMainMenu()
	{
		frame.setVisible(false);
		frame.setContentPane(panelMainMenu);
		frame.setTitle(TITLE_MAIN_MENU);
		frame.setSize(WIDTH_MAIN_MENU, HEIGHT_MAIN_MENU);
		frame.setVisible(true);
	}
	
	// setFrameToPlayerProfile
	public void setFrameToPlayerProfile()
	{
		frame.setVisible(false);
		frame.setContentPane(panelPlayerProfile);
		frame.setTitle(TITLE_PLAYER_PROFILE);
		frame.setSize(WIDTH_PLAYER_PROFILE, HEIGHT_PLAYER_PROFILE);
		frame.setVisible(true);
	}
	
	// setFrameToPlayersList
	public void setFrameToPlayersList()
	{
		frame.setVisible(false);
		frame.setContentPane(panelPlayersList);
		frame.setTitle(TITLE_PLAYERS_LIST);
		frame.setSize(WIDTH_PLAYERS_LIST, HEIGHT_PLAYERS_LIST);
		frame.setVisible(true);
	}
	
	// setFrameToRatingsMenu
	public void setFrameToRatingsMenu()
	{
		frame.setVisible(false);
		frame.setContentPane(panelRatings);
		frame.setTitle(TITLE_RATINGS_MENU);
		frame.setSize(WIDTH_RATINGS_MENU, HEIGHT_RATINGS_MENU);
		frame.setVisible(true);
	}
	
	// setFrameToSeedingMenu
	public void setFrameToSeedingMenu()
	{
		frame.setVisible(false);
		frame.setContentPane(panelSeedTournament);
		frame.setTitle(TITLE_SEEDING_MENU);
		frame.setSize(WIDTH_SEEDING_MENU, HEIGHT_SEEDING_MENU);
		frame.setVisible(true);
	}
	
	// setFrameToTournamentEditor
	public void setFrameToTournamentEditor()
	{
		frame.setVisible(false);
		frame.setContentPane(panelTournamentEditor);
		frame.setTitle(TITLE_TOURNAMENT_EDITOR);
		frame.setSize(WIDTH_TOURNAMENT_EDITOR, HEIGHT_TOURNAMENT_EDITOR);
		frame.setVisible(true);
	}
	
	// setFrameToTournamentManager
	public void setFrameToTournamentManager()
	{
		frame.setVisible(false);
		frame.setContentPane(panelTournamentManager);
		frame.setTitle(TITLE_TOURNAMENT_MANAGER);
		frame.setSize(WIDTH_TOURNAMENT_MANAGER, HEIGHT_TOURNAMENT_MANAGER);
		frame.setVisible(true);
	}
	
	// main
	public static void main(String[] args)
	{
		new TTWindow();
	}
}
