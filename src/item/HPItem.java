package item;

import java.awt.Graphics2D;

import base.Resources;
import entity.Item;
import manager.GameManager;
import manager.ItemManager;
import manager.WeaponManager;

public class HPItem extends Item{
	public HPItem(){
		// TODO Auto-generated constructor stub
		image = Resources.hpImage;
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
			GameManager.instance.aircraft.MaxHP++;
			GameManager.instance.aircraft.HP = GameManager.instance.aircraft.MaxHP;
			ItemManager.instance.removeGameObject(this);
		}
		
		if(y>Resources.height||y<0) {
			ItemManager.instance.removeGameObject(this);
		}else if(x<0||x>Resources.width) {
			ItemManager.instance.removeGameObject(this);
		}
	}
}
