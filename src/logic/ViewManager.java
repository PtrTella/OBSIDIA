package logic;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import logic.game.MapManager;
import obsidia.map.DefaultMap;
import obsidia.players.PlayerList;
import view.Frame;
import view.StartPanel;
import view.TurnPanel;

public class ViewManager {
	
	protected static Frame frame = new Frame();
	private static PlayerList ply = new PlayerList();
	private static MapManager mapManager = new MapManager();
	
	private final List<Color> listColor = Arrays.asList(
		new Color(200,15,15),
		new Color(50,40,235),
		new Color(10,200,30),
		new Color(30,210,210),
		new Color(200,15,150),
		new Color(240,250,20),
		new Color(250,150,30)
		);
	
	public static void main(String[] args) {
		new ViewManager().inizGame(true);
	}
	
	public void inizGame(boolean cleanPlayerList) {
		mapManager.cleanMap();
		//if you want restart with the same player pass cleanPlayerList = false
		if(cleanPlayerList) {
			clearFrame();
			Collections.shuffle(listColor);
			ply.removeAllPlayer();
			new StartPanel(frame);
		}else {
			moveTurn("Map2");
		}
	}
	
	//between a change screen clean the frame
	protected void clearFrame() {
		frame.setVisible(false);
		frame.getContentPane().removeAll();
	}
	
	//StartPanel -> TurnPanel
	public void moveTurn(String map) {
		clearFrame();
		new DefaultMap(map);
		new TurnPanel(frame);
	}

	//exit from the game
	public void exitGame() {
    	System.exit(0);
	}
	
	//return a color of listColor
	public Color getColor(int pos) throws NoSuchElementException{
		return listColor.get(pos);
	}
	
}
