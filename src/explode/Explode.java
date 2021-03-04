package explode;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import base.GameObject;
import base.Resources;
import manager.ExplodeManager;
import manager.GameManager;

public class Explode extends GameObject {

	BufferedImage[] images;
	int edge;
	double index;
	public Explode(int x, int y, int width, int height) {
		images = new BufferedImage[] {
				Resources.explode1,
				Resources.explode2,
				Resources.explode3,
				Resources.explode4,
				Resources.explode5,
				Resources.explode6,
				Resources.explode7,
				Resources.explode8,
				Resources.explode9,
				Resources.explode10,
				Resources.explode11,
				Resources.explode12,
				Resources.explode13,
				Resources.explode14,
				Resources.explode15,
				Resources.explode16
		};
		edge = images.length;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(images[(int)index],(int)x,(int)y,(int)width,(int)height, null);
	}

	@Override
	public void update() {
		index += 0.1;
		if(index>edge) {
			ExplodeManager.instance.removeGameObject(this);
		}
	}
}
