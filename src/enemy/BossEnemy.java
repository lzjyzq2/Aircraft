package enemy;

import java.awt.Graphics2D;

import base.Resources;
import entity.Enemy;
import entity.Bullet.Shooter;
import manager.EnemyManager;
import manager.GameManager;
import manager.WeaponManager;

public class BossEnemy extends Enemy implements Boss {
	
	double time =0;
	
	public BossEnemy() {
		// TODO Auto-generated constructor stub
		image = Resources.bossenemyImage;
		speed = 100;
		HP = 150;
		width = image.getWidth();
		height = image.getHeight();
		grade = 250;
		weapon = WeaponManager.normalWeapon.createClone(x, y, Shooter.Enemy);
		weapon.width = width;
		weapon.height = height;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image,(int)x,(int)y,null);
	}
	@Override
	public void update() {
		weapon.x = x;
		weapon.y = y;
		weapon.update();
		time+=GameManager.deltaTime;
		if(time>2) {
			double centerx = x+width/2;
			double centerx2 = GameManager.instance.aircraft.x+GameManager.instance.aircraft.width/2;
			if(centerx<centerx2) {
				direction.x = 1;
			}else {
				direction.x = -1;
			}
		}
		if(y<200-height)
			y+= direction.getY()*speed*GameManager.deltaTime;
		x+= direction.getX()*speed*GameManager.deltaTime;
		
		if(bangTest(GameManager.instance.aircraft)) {
			GameManager.instance.aircraft.HP -=10*GameManager.deltaTime;
		}
		if(HP<=0) {
			destroy();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		EnemyManager.instance.canCreateBoss = true;
	}
}
