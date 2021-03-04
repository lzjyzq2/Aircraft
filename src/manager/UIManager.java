package manager;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base.GameObject;
import base.InputManager;
import base.Resources;
import manager.GameManager.GameState;

public class UIManager extends GameObject implements MouseListener,FocusListener {

	public static UIManager instance = new UIManager();
	private Rectangle resumerect;
	private Point lifepanelPos;
	private Rectangle lifeRect;
	
	private Rectangle ReGameRect;
	private Rectangle ExitRect;
	
	private UIManager() {
		resumerect = new Rectangle((Resources.width-Resources.continueImage.getWidth())/2,
				(Resources.height-Resources.continueImage.getHeight())/2,
				Resources.continueImage.getWidth(),
				Resources.continueImage.getHeight());
		lifepanelPos = new Point(0, Resources.height-Resources.lifepanelImage.getHeight());
		lifeRect = new Rectangle(lifepanelPos.x+88, 
				lifepanelPos.y+44,
				Resources.lifeImage.getWidth(),
				Resources.lifeImage.getHeight());
		
		ReGameRect = new Rectangle(98, 493, 281, 67);
		ExitRect = new Rectangle(98, 599, 281, 67);
	}

	@Override
	public void draw(Graphics2D g) {
		switch (GameManager.instance.gameState) {
		case Wait:
			g.drawImage(Resources.startImage, 0, 0, Resources.width, Resources.height, null);
			break;
		case Run:
			char[] grades = String.valueOf(GameManager.instance.grade).toCharArray();
			for (int i = 0; i < grades.length; i++) {
				int num = grades[i]-48;
				g.drawImage(Resources.num[num],10+i*Resources.num[num].getWidth(),10,Resources.num[num].getWidth(), Resources.num[num].getHeight(),null);
			}
			g.drawImage(Resources.lifepanelImage, 0,lifepanelPos.y, null);
			double hp = GameManager.instance.aircraft.HP;
			double maxhp = GameManager.instance.aircraft.MaxHP;
			if(hp>0) {
				double parsent = hp/maxhp;
				if(hp>=maxhp) {
					parsent = 1;
				}
				int newwidth = (int) (Resources.lifeImage.getWidth()*parsent);
				lifeRect.width = newwidth;
				g.drawImage(Resources.lifeImage, lifeRect.x, lifeRect.y,lifeRect.width,lifeRect.height, null);
			}
			break;
		case Pause:
			g.drawImage(Resources.pasuebgImage, 0, 0, null);
			g.drawImage(Resources.continueImage, resumerect.x, resumerect.y, null);
			break;
		case End:
			g.drawImage(Resources.gameoverImage, 0, 0, null);
			char[] gradess = String.valueOf(GameManager.instance.grade).toCharArray();
			for (int i = 0; i < gradess.length; i++) {
				int num = gradess[i]-48;
				g.drawImage(Resources.num[num],180+i*Resources.num[num].getWidth(),255,Resources.num[num].getWidth(), Resources.num[num].getHeight(),null);
			}
			break;
		}
	}

	@Override
	public void update() {
		if(InputManager.instance.KeyIsDown(KeyEvent.VK_ESCAPE)&&GameManager.instance.gameState==GameState.Run) {
			GameManager.instance.gameState = GameState.Pause;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (GameManager.instance.gameState) {
		case Wait:
			GameManager.instance.start();
			break;
		case Run:
			
			break;
		case Pause:
			if(resumerect.contains(e.getPoint())) {
				GameManager.instance.gameState = GameState.Run;
			}
			break;
		case End:
			if(ReGameRect.contains(e.getPoint())) {
				GameManager.instance.start();
			}else if (ExitRect.contains(e.getPoint())) {
				System.exit(0);
			}
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(GameManager.instance.gameState==GameState.Run) {
			GameManager.instance.gameState = GameState.Pause;
		}
	}
}
