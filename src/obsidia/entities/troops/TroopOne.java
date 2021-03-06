package obsidia.entities.troops;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

/**
 * 
 * The class determines a level 1 troop.
 * It extends the AbstractCells class and thus 
 * implements the Cells Interface and its methods 
 * not implemented by the abstract class.
 * @see Cells.java
 * @see Troops.java
 * 
 * @author Tellarini Pietro
 *
 */
public class TroopOne extends AbstractCell implements Troops{

	public static final int COST = 10;
	private static final int BALANCE = -2;
	private static final int DEFENCE = 1;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	private static final int OFFENCE = 1;
	
	public TroopOne(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getCost() {
		return TroopOne.COST;
	}
	

	@Override
	public int getBalance() {
		return TroopOne.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopOne.DEFENCE;
	}

	@Override
	public int getMovement() {
		return TroopOne.MOVEMENT;
	}

	@Override
	public int getOffence() {
		return TroopOne.OFFENCE;
	}

	@Override
	public int getLevel() {
		return 1;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "troop1.png");
	}

}
