package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;

import base.GameObject;
import base.InputManager;
import base.Resources;
import entity.Bullet.Shooter;
import manager.GameManager;
import manager.WeaponManager;
import manager.GameManager.GameState;

public class Aircraft extends GameObject{
	double speed = 1000*GameManager.deltaTime;
	
	public Weapon weapon;
	public int HP = 100;
	private BufferedImage image = Resources.heroImage;
	public int MaxHP = 100;
	public Aircraft() {
		x = 200;
		y= 500;
		width = image.getWidth();
		height = image.getHeight();
		weapon = WeaponManager.normalWeapon.createClone((int)x, (int)y, Shooter.Player);
		weapon.width = width;
		weapon.height = height;
		yedge = Resources.height-height-speed-Resources.lifepanelImage.getHeight();
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	private double yedge;
	@Override
	public void update() {
		weapon.x = x;
		weapon.y = y;
		if(InputManager.instance.KeyIsDown(KeyEvent.VK_UP)&&y>0) {
			y-=speed;
		}else if (InputManager.instance.KeyIsDown(KeyEvent.VK_DOWN)&&y<yedge) {
			y+=speed;
		}
		if (InputManager.instance.KeyIsDown(KeyEvent.VK_LEFT)&&x>0) {
			x-=speed;
		}else if (InputManager.instance.KeyIsDown(KeyEvent.VK_RIGHT)&&x<Resources.width-width-speed) {
			x+=speed;
		}
		weapon.update();
		if(HP<=0) {
			GameManager.instance.gameState = GameState.End;
		}
	}
	
	public void useWeapon(Weapon weapon) {
		this.weapon = weapon.createClone(x,y, Shooter.Player);
		this.weapon.width = width;
		this.weapon.height = height;
	}
}
