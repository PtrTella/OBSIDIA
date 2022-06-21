package obsidia.entities.towers;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TowerTwo extends AbstractCell implements Towers{

	public static final int COST_LV2 = 25;
	private static final int BALANCE_LV2 = -6;
	private static final int DEFENCE_LV2 = 3;

	public TowerTwo(String Player, Coordinates xy) {
		super(Player, xy);
	}
	
	@Override
	public int getCost() {
		return TowerTwo.COST_LV2;
	}
	
	@Override
	public int getBalance() {
		return TowerTwo.BALANCE_LV2;
	}
	
	@Override
	public int getDefence() {
		return TowerTwo.DEFENCE_LV2;
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "tower2.png");
	}
}
