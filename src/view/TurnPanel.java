package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logic.TurnManager;
import logic.ViewManager;
import obsidia.utilities.Coordinates;

public class TurnPanel {

	private final Map<JButton,Coordinates> cells = new HashMap<>();
	//private FarmManger farmManager;
	//private TowerManager towerManager;
	//private TroopManager troopManager;
	private ViewManager viewManager = new ViewManager();
	private TurnManager turnManager = new TurnManager();
	
	//JPanel
	private JPanel mapPanel;
	private JPanel southPanel;
	
	//JButton
	private final int bDimension = 20;
	private final JButton troop = new Button("TROOP", bDimension);
	private final JButton tower = new Button("TOWER", bDimension);
	private final JButton farm = new Button("FARM",bDimension);
	private final JButton skip = new Button("SKIP PLAYER >>", bDimension);
	private final JButton exit = new Button("END GAME", bDimension);
	
	//JLabel
	private final int lDimension = 20;
	private final JLabel moneyLabel = new Label("MONEY:", lDimension);
	private JLabel money;
	private final JLabel balanceLabel = new Label("BALANCE:", lDimension);
	private JLabel balance;
	
	public TurnPanel(Frame frame) {
		
		frame.setFrameLayout(new BorderLayout());

		mapPanel = new JPanel(new GridLayout(turnManager.mapHeight(),turnManager.mapWidth()));
		mapPanel.setBorder(new EmptyBorder(2,2,2,2));
		
		ActionListener actionL = e -> {
			//var position = cells.get(e.getSource());
			
		};
		
		//create and add button in the Map cells
        for (int i=0; i<turnManager.mapHeight(); i++){
            for (int j=0; j<turnManager.mapWidth(); j++){
                final JButton jb = new JButton(" X ");
                jb.setBackground(Color.LIGHT_GRAY);
                jb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                cells.put(jb, new Coordinates(i,j));
                mapPanel.add(jb);
                jb.addActionListener(actionL);
            }
        }

		southPanel = new JPanel(new FlowLayout());
		southPanel.setBackground(Color.DARK_GRAY);
		
		//TODO: get the money from the method in CoinManager
		money = new Label("10", lDimension);
		//TODO: get the balance from the method in CoinManager
		balance = new Label("0", lDimension);
        
		Border border = BorderFactory.createLineBorder(Color.WHITE);
        troop.setBorder(border);
        tower.setBorder(border);
        farm.setBorder(border);
        skip.setBorder(border);
        exit.setBorder(border);
        moneyLabel.setForeground(Color.WHITE);
        money.setForeground(Color.WHITE);
        balanceLabel.setForeground(Color.WHITE);
        balance.setForeground(Color.WHITE);
        
        troop.setEnabled(false);
        tower.setEnabled(false);
        farm.setEnabled(false);
        
        southPanel.add(troop);
        southPanel.add(tower);
        southPanel.add(farm);
        southPanel.add(skip);
        southPanel.add(exit);
        southPanel.add(Box.createHorizontalStrut(30));
        southPanel.add(moneyLabel);
        southPanel.add(money);
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(balanceLabel);
        southPanel.add(balance);
        
        troop.addActionListener(e -> {
			//this.manager.newTroop();
		});
        
        tower.addActionListener(e -> {
			//this.manager.newTower();
		});
        
        farm.addActionListener(e -> {
			//this.manager.newFarm();
		});
        
        skip.addActionListener(e -> {
        	
        });
        
        exit.addActionListener(e -> {
        	if(JOptionPane.showConfirmDialog(
        			frame,
        			"Quit the game ?",
        			"ENDGAME",
        			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        		this.viewManager.moveEnd();
        });
        
        
        frame.addComponent(mapPanel,BorderLayout.CENTER);
        frame.addComponent(southPanel,BorderLayout.SOUTH);      
    	
    	frame.setVisible(true);
	}
	
	public void setBorder(boolean bool, Set<Coordinates> c) {
		this.cells.forEach((b,p) -> {
			b.setBorder( (c.contains(p) && bool == true) ? 
					BorderFactory.createLineBorder(Color.RED, 5) :
					BorderFactory.createLineBorder(Color.BLACK, 5));
		});
	}
}