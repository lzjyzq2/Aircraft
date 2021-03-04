package base;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {
	public static BufferedImage backgroundImage;
	
	public static BufferedImage pasuebgImage;
	public static BufferedImage continueImage;
	
	public static BufferedImage gameoverImage;
	
	public static BufferedImage lifepanelImage;
	public static BufferedImage lifeImage;
	
	
	public static BufferedImage heroImage;
	public static BufferedImage normalbulletImage;
	public static BufferedImage normalenemyImage;
	public static BufferedImage attackerenemyImage;
	public static BufferedImage bossenemyImage;
	
	
	public static BufferedImage explode1;
	public static BufferedImage explode2;
	public static BufferedImage explode3;
	public static BufferedImage explode4;
	public static BufferedImage explode5;
	public static BufferedImage explode6;
	public static BufferedImage explode7;
	public static BufferedImage explode8;
	public static BufferedImage explode9;
	public static BufferedImage explode10;
	public static BufferedImage explode11;
	public static BufferedImage explode12;
	public static BufferedImage explode13;
	public static BufferedImage explode14;
	public static BufferedImage explode15;
	public static BufferedImage explode16;

	public static BufferedImage LaserWeaponItemImage;
	
	public static BufferedImage laser1;
	public static BufferedImage laser2;
	public static BufferedImage laser3;
	
	public static BufferedImage[] num;
	
	public static BufferedImage num1;
	public static BufferedImage num2;
	public static BufferedImage num3;
	public static BufferedImage num4;
	public static BufferedImage num5;
	public static BufferedImage num6;
	public static BufferedImage num7;
	public static BufferedImage num8;
	public static BufferedImage num9;
	public static BufferedImage num0;
	
	public static int width ;
	public static int height;
	public static BufferedImage startImage;
	public static BufferedImage hpImage;
	public static File bgm;
	static {
		try {
			backgroundImage = ImageIO.read(Resources.class.getResource("/bg3.jpg"));
			pasuebgImage = ImageIO.read(Resources.class.getResource("/pausebg.png"));
			continueImage = ImageIO.read(Resources.class.getResource("/continue.png"));
			gameoverImage = ImageIO.read(Resources.class.getResource("/gameover.jpg"));
			
			lifepanelImage = ImageIO.read(Resources.class.getResource("/lifepanel.png"));
			lifeImage = ImageIO.read(Resources.class.getResource("/life.png"));
			heroImage = ImageIO.read(Resources.class.getResource("/hero.png"));
			normalbulletImage = ImageIO.read(Resources.class.getResource("/NormalBullet.png"));
			normalenemyImage = ImageIO.read(Resources.class.getResource("/enemy1.png"));
			attackerenemyImage = ImageIO.read(Resources.class.getResource("/enemy2.png"));
			bossenemyImage = ImageIO.read(Resources.class.getResource("/boss1.png"));
			
			width = 480;
			height = 800;
			explode1 = ImageIO.read(Resources.class.getResource("/explode1.png"));
			explode2 = ImageIO.read(Resources.class.getResource("/explode2.png"));
			explode3 = ImageIO.read(Resources.class.getResource("/explode3.png"));
			explode4 = ImageIO.read(Resources.class.getResource("/explode4.png"));
			explode5 = ImageIO.read(Resources.class.getResource("/explode5.png"));
			explode6 = ImageIO.read(Resources.class.getResource("/explode6.png"));
			explode7 = ImageIO.read(Resources.class.getResource("/explode7.png"));
			explode8 = ImageIO.read(Resources.class.getResource("/explode8.png"));
			explode9 = ImageIO.read(Resources.class.getResource("/explode9.png"));
			explode10 = ImageIO.read(Resources.class.getResource("/explode10.png"));
			explode11 = ImageIO.read(Resources.class.getResource("/explode11.png"));
			explode12 = ImageIO.read(Resources.class.getResource("/explode12.png"));
			explode13 = ImageIO.read(Resources.class.getResource("/explode13.png"));
			explode14 = ImageIO.read(Resources.class.getResource("/explode14.png"));
			explode15 = ImageIO.read(Resources.class.getResource("/explode15.png"));
			explode16 = ImageIO.read(Resources.class.getResource("/explode16.png"));
			
			LaserWeaponItemImage = ImageIO.read(Resources.class.getResource("/laserweaponitem.png"));
			laser1 = ImageIO.read(Resources.class.getResource("/laser1.png"));
			laser2 = ImageIO.read(Resources.class.getResource("/laser2.png"));
			laser3 = ImageIO.read(Resources.class.getResource("/laser3.png"));
			
			hpImage = ImageIO.read(Resources.class.getResource("/hpitem.png"));
			
			startImage = ImageIO.read(Resources.class.getResource("/start.jpg"));
			
			num0 = ImageIO.read(Resources.class.getResource("/num0.png"));
			num1 = ImageIO.read(Resources.class.getResource("/num1.png"));
			num2 = ImageIO.read(Resources.class.getResource("/num2.png"));
			num3 = ImageIO.read(Resources.class.getResource("/num3.png"));
			num4 = ImageIO.read(Resources.class.getResource("/num4.png"));
			num5 = ImageIO.read(Resources.class.getResource("/num5.png"));
			num6 = ImageIO.read(Resources.class.getResource("/num6.png"));
			num7 = ImageIO.read(Resources.class.getResource("/num7.png"));
			num8 = ImageIO.read(Resources.class.getResource("/num8.png"));
			num9 = ImageIO.read(Resources.class.getResource("/num9.png"));
			
			num = new BufferedImage[] {
					num0,num1,num2,num3,num4,num5,num6,num7,num8,num9
			};
			bgm = new File(Resources.class.getResource("/bgm.mp3").getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
