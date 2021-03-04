package entity;

import java.awt.Point;
import java.awt.Rectangle;

import base.GameObject;
import entity.Bullet.Shooter;
import weapon.NormalWeapon;

public class Weapon extends GameObject {
	
	public double x;
	public double y;
	public double width;
	public double height;
	
	public Bullet bullet;
	public Shooter shooter;
	public Weapon() {
		// TODO Auto-generated constructor stub
	}
	public Weapon createClone(double x,double y,Shooter shooter) {
		Weapon weapon = null;
		try {
			weapon = (Weapon) this.clone();
			weapon.x = x;
			weapon.y = y;
			weapon.shooter = shooter;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return weapon;
	}
}
