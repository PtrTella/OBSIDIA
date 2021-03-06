package logic.game;

import java.awt.Color;

import javax.swing.ImageIcon;

import logic.ManagerImplementation;
import obsidia.map.DefaultMap;
import obsidia.utilities.Coordinates;

public class MapManager extends ManagerImplementation{
	
	DefaultMap def = new DefaultMap();

	@Override
	public void defaultMapLoad(String file) {
		def.setMap(file);
		def.loadMap();
		def.createMap();
	}

	@Override
	public String[] defaulMapGive() {
		return def.listMap();
	}
	
	@Override
	public void cleanMap() {
		ManagerImplementation.map
		.cleanMap();
	}	
	
	@Override
	public ImageIcon iconCell(Coordinates pos) {
		return 	ManagerImplementation.map
				.getEntity(pos)
				.getIcon();
	}
	
	public Color colorCell(Coordinates pos) {
		return ManagerImplementation.ply
				.getColorName(ManagerImplementation.map.getOwner(pos));
	}
	
	public boolean isEnableCell(Coordinates pos) {
		return ManagerImplementation.map.getOwner(pos) == null;
	}
	
	@Override
	public int mapWidth() {
		return ManagerImplementation.map.getWidth();
	}
	
	@Override
	public int mapHeight() {
		return ManagerImplementation.map.getHeight();
	}
	
}

