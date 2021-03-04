package enemy;

import java.awt.Graphics2D;

import base.Resources;
import entity.Enemy;
import manager.EnemyManager;
import manager.GameManager;

public class NormalEnemy extends Enemy {

	boolean canBang = true;
	
	public NormalEnemy() {
		// TODO Auto-generated constructor stub
		image = Resources.normalenemyImage;
		speed = 200;
		this.x=0;
		this.y=0;
		HP = 5;
		width = image.getWidth();
		height = image.getHeight();
		grade = 10;
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image,(int)x,(int)y,null);
	}
	@Override
	public void update() {
		x+= direction.getX()*speed*GameManager.deltaTime;
		y+= direction.getY()*speed*GameManager.deltaTime;
		if(HP<=0) {
			destroy();
		}
		if(bangTest(GameManager.instance.aircraft)&&canBang) {
			GameManager.instance.aircraft.HP -=2;
			canBang = false;
		}
		if(y>Resources.height) {
			EnemyManager.instance.removeGameObject(this);
		}
	}
}
