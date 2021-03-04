package item;

import java.awt.Graphics2D;

import base.GameObject;
import base.Resources;
import entity.Item;
import entity.Weapon;
import entity.Bullet.Shooter;
import manager.EnemyManager;
import manager.GameManager;
import manager.ItemManager;
import manager.WeaponManager;

public class LaserWeaponItem extends Item{
	
	public LaserWeaponItem(){
		// TODO Auto-generated constructor stub
		image = Resources.LaserWeaponItemImage;
		speed = 100;
		this.x=0;
		this.y=0;
		width = image.getWidth();
		height = image.getHeight();
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image,(int)x,(int)y,null);
	}
	@Override
	public void update() {
		x+= direction.getX()*speed*GameManager.deltaTime;
		y+= direction.getY()*speed*GameManager.deltaTime;
		
		if(bangTest(GameManager.instance.aircraft)) {
			GameManager.instance.aircraft.useWeapon(WeaponManager.laserWeapon);
			ItemManager.instance.removeGameObject(this);
		}
		
		if(y>Resources.height||y<0) {
			ItemManager.instance.removeGameObject(this);
		}else if(x<0||x>Resources.width) {
			ItemManager.instance.removeGameObject(this);
		}
	}
}
