package obsidia.map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import obsidia.entities.buildings.Castle;
import obsidia.entities.cells.FreeCell;
import obsidia.entities.troops.TroopOne;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

/**
 * 
 * This class provides the methods for reading and 
 * loading predefined game maps, saved on a text file.
 * 
 * @author Tellarini Pietro
 * 
 */
public class DefaultMap {
	
	private static final int CASTLE = Character.getNumericValue('0');
	private static final int TERRAIN = Character.getNumericValue('A');
	private static final int NULL = Character.getNumericValue('.');
	
	private final String dir = "data";

	private GameMap map = new GameMap();
	private PlayerList ply = new PlayerList();
	
	private String[] dat;
	private Path path;
	
	public DefaultMap() {
		this("Map1");
	}
	
	public DefaultMap(final String fileName) {
		setMap(fileName);
	}
	
	/**
	 * @return All map file name in folder dir (variable)
	 */
	public String[] listMap() {
		File file = new File(dir);
		return file.list();
	}
	
	/**
	 * Set the path based on the map file name
	 * @param fileName
	 */
	public void setMap(String fileName) {
		path = Path.of(dir + File.separator + fileName);
	}
	
	/**
	 * Reads the file indicated by the path 
	 * and saves it on an array of strings
	 */
	public void loadMap() {

		try {
			dat = Files.readString(path).split("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		map.setDimension(
				Character.getNumericValue(dat[0].charAt(0))*10 +
				Character.getNumericValue(dat[0].charAt(1)), 
				Character.getNumericValue(dat[0].charAt(2))*10 +
				Character.getNumericValue(dat[0].charAt(3)));
		
	}
	
	/**
	 * Parse the strings containing the information 
	 * of the map file and create the respective entities 
	 * by saving them on the map
	 */
	public void createMap() {		

		for(int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j< map.getWidth(); j++) {
				
				int entity =Character.getNumericValue(dat[i+1].charAt(j));
				
				if(entity >= DefaultMap.CASTLE && entity < (DefaultMap.CASTLE + ply.numberPlayer())) {
					
					map.addEntity(new Castle(ply.getNameIndex(entity - DefaultMap.CASTLE), new Coordinates(i,j)));			
					
				} else if(entity >= DefaultMap.TERRAIN && entity < (DefaultMap.TERRAIN + ply.numberPlayer())){
					
					//map.addEntity(new FreeCell(ply.getNameIndex(entity - DefaultMap.TERRAIN), new Coordinates(i,j))); 
					map.addEntity(new TroopOne(ply.getNameIndex(entity - DefaultMap.TERRAIN), new Coordinates(i,j))); 
					
				} else if(entity == DefaultMap.NULL) {
					map.addEntity(new FreeCell(null, new Coordinates(i,j)));
				} else {					
					map.addEntity(new FreeCell("", new Coordinates(i, j)));
				} 
			}
		}
		
	}
	
	
	
	
}
