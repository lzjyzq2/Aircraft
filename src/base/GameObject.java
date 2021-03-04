package base;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameObject implements Cloneable {
	public double x;
	public double y;
	public double width;
	public double height;

	public void update() {

	}

	public void draw(Graphics2D g) {

	}

	public boolean bangTest(GameObject gameObject) {
		boolean flag = false;
		//子弹的中心点坐标
		double bx = gameObject.x+gameObject.width/2;
		double by = gameObject.y+gameObject.height/2;
		//降落物的中心点坐标
		double fx = this.x+this.width/2;
		double fy = this.y+this.height/2;
		
		//求出两点的距离
		double distance = Math.sqrt(Math.pow(bx-fx,2)+Math.pow(by-fy,2));
		double min = gameObject.height/2+this.height/2;
		double max = Math.sqrt(Math.pow((this.height+gameObject.height)/2, 2)+Math.pow((this.width+gameObject.width)/2, 2));
		if(min<=distance&&distance<=max) {
			flag = true;
		}
		return flag;
//		double x1 = this.x;
//		double x2 = this.x+this.width;
//		double y1 = this.y;
//		double y2 = this.y+this.height;
//		double x = gameObject.x;
//		double y = gameObject.y;
//		return x>=x1&&x<=x2&&y>=y1&&y<=y2;
		
//		return ( Math.abs((x+x+width)-(gameObject.x+gameObject.x+gameObject.width))<(x+width-x+gameObject.x+gameObject.width-gameObject.x)
//		        && Math.abs((y+y+width)-(gameObject.y+gameObject.y+gameObject.height))<(y+width-y+gameObject.y+gameObject.height-gameObject.y) );
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
