package manager;

import java.awt.Point;

import Utils.RandonUtils;
import base.GameObjectCollection;
import base.Resources;
import item.BombWeaponItem;
import item.HPItem;
import item.LaserWeaponItem;

public class ItemManager extends GameObjectCollection{
	public static ItemManager instance = new ItemManager();
	
	public static LaserWeaponItem laserWeaponItem = new LaserWeaponItem();
	public static HPItem hpItem = new HPItem();
	public static BombWeaponItem bombWeaponItem = new BombWeaponItem();
	public double time=0;
	public Point direction = new Point(0,1);
	
	@Override
	public void update() {
		super.update();
		time +=1*GameManager.deltaTime;
		if(time>4) {
			time = 0;
			ItemManager.instance.addGameObject(ItemManager.hpItem.newItem(RandonUtils.getRandomInt(Resources.width), -hpItem.height,direction));
		}
	}
	public void init() {
		gameobjects.clear();
	}
}
