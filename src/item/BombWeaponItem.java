package item;

import java.awt.Graphics2D;

import base.Resources;
import enemy.Boss;
import entity.Enemy;
import entity.Item;
import manager.EnemyManager;
import manager.GameManager;
import manager.ItemManager;

public class BombWeaponItem extends Item {
	public BombWeaponItem(){
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
			//GameManager.instance.aircraft.useWeapon(WeaponManager.laserWeapon);
			for (int i = 0; i < EnemyManager.instance.gameobjects.size(); i++) {
				Enemy enemy = (Enemy) EnemyManager.instance.gameobjects.get(i);
				if(enemy instanceof Boss) {
					enemy.HP -=120;
				}else {
					enemy.destroy();
					i--;
				}
			}
			ItemManager.instance.removeGameObject(this);
		}
		
		if(y>Resources.height||y<0) {
			ItemManager.instance.removeGameObject(this);
		}else if(x<0||x>Resources.width) {
			ItemManager.instance.removeGameObject(this);
		}
	}
}
