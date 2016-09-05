package com.xaoilin.GameObjects;

import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.GameWorld.Helper;

public class Square {

	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();
	public int once = 0;

	public float[] verticesPoly = new float[8];
	public short[] indices = Helper.earclip.computeTriangles(verticesPoly).toArray();

	public float speed, rotation, color, pulsating;
	public float singleRotation;
	public float originX, originY;

	static AtomicInteger nextId = new AtomicInteger();
	public int id;

	public Square() {
		if(nextId.get() == Shapes.SHAPES_SIZE){
			nextId.set(1);
			id = nextId.get();
		}else{
			id = nextId.incrementAndGet();
		}
	}

	public void resetVariables() {
		this.rectX = 0;
		this.rectY = 0;
		this.width = 0;
		this.height = 0;
		this.verticesPoly = new float[8];
		this.originX = 0;
		this.originY = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.singleRotation = 0;
		this.once = 0;
		this.rectBounds = new Rectangle();
	}

	public void drawSquare(float x, float y, float w, float h, float r, float speed, float color, float puls, float singleRotation) {

		if (once == 0) {
			System.out.println("Draw Square");

			// SET RECTANGLE BOUNDS
			this.rectX = x;
			this.rectY = y;
			this.width = w;
			this.height = h;

			// Rotation Purposes
			originX = x;
			originY = y;

			// Mesh
			float[] verticiesRect = { x, y, x, y, x, y, x, y };
			this.verticesPoly = verticiesRect;

			this.speed = speed;
			this.rotation = r;
			this.color = color;
			this.pulsating = puls;
			this.singleRotation = singleRotation;

			once++;
		}

		rectBounds.set(rectX, rectY, width, height);

		rectX -= speed;
		rectY -= speed;
		width += speed * 2;
		height += speed * 2;

		normal();
		// Update Indices once after poly()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}

	public void normal() {

		// Top Left
		verticesPoly[0] -= speed;
		verticesPoly[1] -= speed;
		// Top Right
		verticesPoly[2] += speed;
		verticesPoly[3] -= speed;
		// Bottom Right
		verticesPoly[4] += speed;
		verticesPoly[5] += speed;
		// Bottom Left
		verticesPoly[6] -= speed;
		verticesPoly[7] += speed;
	}

}
