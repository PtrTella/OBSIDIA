package obsidia.entities.towers;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TowerOne extends AbstractCell implements Towers{

	public static final int COST_LV1 = 15;
	private static final int BALANCE_LV1 = -1;
	private static final int DEFENCE_LV1 = 2;
	
	public TowerOne(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}

	@Override
	public int getCost() {
		return TowerOne.COST_LV1;
	}

	@Override
	public int getBalance() {
		return TowerOne.BALANCE_LV1;
	}
	
	@Override
	public int getDefence() {
		return TowerOne.DEFENCE_LV1;
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "tower1.png");
	}
}
