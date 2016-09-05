package com.xaoilin.GameObjects;


import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Circles {

	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();

	// CIRCLES
	public float radius, circleX, circleY;
	public Circle circleBounds = new Circle();
	public int onceCircle = 0;
	public double speed, rotation, color, pulsating;
	public float singleRotation;

	public void resetVariables(){
//		System.out.println("CIRCLE RESET VARIABLES");
		this.rectX = 0;
		this.rectY = 0;
		this.width = 0;
		this.height = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.onceCircle = 0;
		this.rectBounds = new Rectangle();
		this.circleBounds = new Circle();
		this.radius = 0;
		this.singleRotation = 0;
	}
	
	public void normalCircle(int x, int y, float w, float h, double rotation, double speed, double color, double puls, float singleRotation) {

		if (onceCircle == 0) {
			System.out.println("Draw Circle");
			//Circle Bounds
			this.circleX = x;
			this.circleY = y;
			this.radius = w;
			
			//Image
			this.rectX = x;
			this.rectY = y;
			this.width = w;
			this.height = h;
			
			this.speed = 0.5 * speed;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			onceCircle++;
		}

		//Circle Bounds
		circleBounds.set(circleX, circleY, radius);

		radius += speed;
		
		//Image
		rectBounds.set(rectX, rectY, width, height);

		rectX -= speed;
		rectY -= speed;
		width += speed * 2;
		height += speed * 2;
//		System.out.printf("width: %f \theight: %f \tx: %f \t y:%f\n", width, height, rectX, rectY);
		
	}

}
