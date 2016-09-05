package com.xaoilin.GameObjects;

import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.GameWorld.Helper;

public class Triangle {
	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();

	// TRIANGLES
	public float[] verticesPoly = new float[6];
	public float[] verticesMesh = new float[12];
	public short[] indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
	public int once = 0;
	public double speed, rotation, color, pulsating;
	public float singleRotation;
	public int originX, originY;

	static AtomicInteger nextId = new AtomicInteger();
	public int id;

	public Triangle() {
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
		this.rectBounds = new Rectangle();
		this.verticesPoly = new float[6];
		this.verticesMesh = new float[12];
		this.originX = 0;
		this.originY = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.singleRotation = 0;
		this.once = 0;
	}

	public void drawTriangle(int x, int y, float w, float h, double rotation, double speed, double color, double puls, float singleRotation) {

		if (once == 0) {
			System.out.println("Triangle entered");
			// Image
			this.rectX = x;
			this.rectY = y;
			this.width = w;
			this.height = h;

			// Rotation purposes
			originX = x;
			originY = y;

			// Mesh Purposes
			float colour = Color.toFloatBits(0, 0, 0, 255); // default is black
			if (color == 1) {
				colour = Color.toFloatBits(255, 255, 255, 255); // set to white
			}
			float z = 0;
			float[] vertices = { x, y, z, colour, x, y, z, colour, x, y, z, colour };
			float[] verticesTri = { x, y, x, y, x, y, };
			this.verticesMesh = vertices;
			this.verticesPoly = verticesTri;

			this.speed = speed;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			this.singleRotation = singleRotation;

			once++;
		}

		// Triangle Polygon
		poly();

		// Image
		rectX -= this.speed;
		rectY -= this.speed;
		width += this.speed * 2;
		height += this.speed * 2;

		// Update Indices once after grow()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}

	public void poly() {

		// Top
		verticesPoly[0] += this.speed * 0.01;
		verticesPoly[1] -= this.speed; // go up Y

		// Bottom Left
		verticesPoly[2] -= this.speed; // go left X
		verticesPoly[3] += this.speed; // go down Y

		// Bottom Right
		verticesPoly[4] += this.speed; // go right X
		verticesPoly[5] += this.speed; // go Down Y
	}

	public float[] getMeshVertices(Polygon poly) {
		// Top
		verticesMesh[0] = poly.getTransformedVertices()[0]; // go left X
		verticesMesh[1] = poly.getTransformedVertices()[1]; // go up Y

		// Right
		verticesMesh[4] = poly.getTransformedVertices()[2]; // go right X
		verticesMesh[5] = poly.getTransformedVertices()[3]; // go up Y

		// Bottom Right
		verticesMesh[8] = poly.getTransformedVertices()[4]; // go right X
		verticesMesh[9] = poly.getTransformedVertices()[5]; // go down Y

		return verticesMesh;
	}
}
