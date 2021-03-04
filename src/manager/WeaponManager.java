package manager;

import java.util.ArrayList;
import java.util.List;

import base.GameObjectCollection;
import entity.Weapon;
import weapon.LaserWeapon;
import weapon.NormalWeapon;

public class WeaponManager{
	public static WeaponManager instance = new WeaponManager();
	public static NormalWeapon normalWeapon = new NormalWeapon();
	public static LaserWeapon laserWeapon = new LaserWeapon();
}
