package com.xaoilin.GameObjects;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.GameWorld.Helper;

public class Pentagon {

	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();
	Random rand;
	// PETNAGON
	public float[] verticesMesh = new float[20];
	public float[] verticesPoly = new float[10];
	public short[] indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
	public int once = 0;
	public double speed, rotation, color, pulsating;
	public float originX, originY;

	static AtomicInteger nextId = new AtomicInteger();
	public int id;

	public Pentagon() {
		if(nextId.get() == Shapes.SHAPES_SIZE){
			nextId.set(1);
			id = nextId.get();
		}else{
			id = nextId.incrementAndGet();
		}
		rand = new Random();
	}

	public void resetVariables() {
		this.verticesPoly = new float[10];
		this.verticesMesh = new float[20];
		this.originX = 0;
		this.originY = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.once = 0;
	}

	public void normalPentagon(int x, int y, float w, float h, double rotation, double s, double color, double puls) {

		if (once == 0) {
			System.out.println("Pentagon entered");

			// Image
			this.rectX = x;
			this.rectY = y;
			this.width = w;
			this.height = h;

			// Rotation Purposes
			originX = x;
			originY = y;

			// Mesh Purposes
			float colour = Color.toFloatBits(0, 0, 0, 255); // default is black
			if (color == 1) {
				colour = Color.toFloatBits(255, 255, 255, 255);
			}
			float z = 0;
			float[] vertices = { x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour };
			float[] verticesPent = { x, y, x, y, x, y, x, y, x, y };
			this.verticesMesh = vertices;
			this.verticesPoly = verticesPent;

			this.speed = s;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			
			once++;
		}

		rectX -= speed;
		rectY -= speed;
		width += speed * 2;
		height += speed * 2;

		poly();
		// normal();

		// Update Indices once after poly()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}

	public void normal() {

		// Top
		verticesMesh[3] = Color.toFloatBits(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255); // go																					// left
																											// X
		verticesMesh[7] = Color.toFloatBits(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255); // go
																											// up
																											// Y

		// Right
		verticesMesh[11] = Color.toFloatBits(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255); // go
																											// right
																											// X
		verticesMesh[15] = Color.toFloatBits(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255); // go
																											// up
																											// Y

		// Bottom Right
		verticesMesh[19] = Color.toFloatBits(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255); // go
																											// right
																											// X

	}

	public void poly() {
		// Top
		verticesPoly[0] -= speed * 0.03; // go left X
		verticesPoly[1] -= speed * 0.86; // go up Y

		// Right
		verticesPoly[2] += speed * 0.88; // go right X
		verticesPoly[3] -= speed * 0.22; // go up Y

		// Bottom Right
		verticesPoly[4] += speed * 0.54; // go right X
		verticesPoly[5] += speed * 0.85; // go down Y

		// Bottom Left
		verticesPoly[6] -= speed * 0.58; // go left X
		verticesPoly[7] += speed * 0.85; // go down Y

		// Left
		verticesPoly[8] -= speed * 0.92; // go left X
		verticesPoly[9] -= speed * 0.22; // go up Y
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

		// Bottom Left
		verticesMesh[12] = poly.getTransformedVertices()[6]; // go left X
		verticesMesh[13] = poly.getTransformedVertices()[7]; // go down Y

		// Left
		verticesMesh[16] = poly.getTransformedVertices()[8]; // go left X
		verticesMesh[17] = poly.getTransformedVertices()[9]; // go up Y
		return verticesMesh;
	}
}