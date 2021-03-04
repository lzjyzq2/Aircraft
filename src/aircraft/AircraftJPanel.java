package aircraft;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import base.InputManager;
import base.Resources;
import manager.GameManager;
import manager.UIManager;

public class AircraftJPanel extends JPanel implements Runnable,KeyListener{
	
	Thread thread;
	GameManager gameManager = GameManager.instance;
	public AircraftJPanel() {
		addKeyListener(this);
		addMouseListener(UIManager.instance);
		addFocusListener(UIManager.instance);
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D)g;
		gameManager.draw(graphics2d);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		InputManager.instance.KeyDown(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.instance.KeyUp(e.getKeyCode());
	}
	@Override
	public void run() {
		while (true) {
			gameManager.update();
			repaint();
			try {
				Thread.sleep((int)GameManager.updateTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
