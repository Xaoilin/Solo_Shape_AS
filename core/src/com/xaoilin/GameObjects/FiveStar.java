package com.xaoilin.GameObjects;

import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.GameWorld.Helper;

public class FiveStar {

	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();

	// STARS
	public float[] verticesPoly = new float[20];
	public float[] verticesMesh = new float[40];
	public short[] indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
	public int once = 0, pulsatingCounter = 0, pulsatingOnce = 0;
	public double speed, rotation, color, pulsating;
	public float singleRotation;
	public float originX, originY;

	static AtomicInteger nextId = new AtomicInteger();
	public int id;

	public FiveStar() {
		if(nextId.get() == Shapes.SHAPES_SIZE){
			nextId.set(1);
			id = nextId.get();
		}else{
			id = nextId.incrementAndGet();
		}
	}

	public void resetVariables() {
		this.width = 0;
		this.height = 0;
		this.rectX = 0;
		this.rectY = 0;
		this.rectBounds = new Rectangle();
		this.verticesPoly = new float[20];
		this.verticesMesh = new float[40];
		this.originX = 0;
		this.originY = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.once = 0;
		this.singleRotation = 0;
	}

	public void normalStar(int x, int y, float w, float h, double rotation, double s, double color, double puls, float singleRotation) {

		if (once == 0) {
			System.out.println("5 pointed star entered");
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
			float[] vertices = { x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x,
					y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour };
			float[] verticesStar = { x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y };
			this.verticesMesh = vertices;
			this.verticesPoly = verticesStar;

			this.speed = s;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			this.singleRotation = singleRotation;
			once++;
		}

		// Star Polygon
		if(pulsating == 0){
			poly();
		}else if(pulsating == 1){
			pulsating();
		}

		// Image
		rectBounds.set(rectX, rectY, width, height);

		rectX -= speed;
		rectY -= speed;
		width += speed * 2;
		height += speed * 2;
		// Update Indices once after grow()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}

	public void poly() {
		// Top
		verticesPoly[0] += speed * 0.01; // go right X
		verticesPoly[1] -= speed * 0.98; // go up Y

		// Top Right Indent
		verticesPoly[2] += speed * 0.257; // go right X
		verticesPoly[3] -= speed * 0.24; // go up Y

		// Right
		verticesPoly[4] += speed * 1; // go right X
		verticesPoly[5] -= speed * 0.22; // go up Y

		// Bottom Right Indent
		verticesPoly[6] += speed * 0.41; // go right X
		verticesPoly[7] += speed * 0.25; // go down Y

		// Bottom Right
		verticesPoly[8] += speed * 0.62; // go right X
		verticesPoly[9] += speed * 1; // go down Y

		// Bottom Indent
		verticesPoly[10] += speed * 0.01; // go right X
		verticesPoly[11] += speed * 0.56; // go down Y

		// Bottom Left
		verticesPoly[12] -= speed * 0.60; // go left X
		verticesPoly[13] += speed * 1; // go down Y

		// Bottom Left Indent
		verticesPoly[14] -= speed * 0.39; // go left X
		verticesPoly[15] += speed * 0.25; // go down Y

		// Left
		verticesPoly[16] -= speed * 0.98; // go left X
		verticesPoly[17] -= speed * 0.22; // go up Y

		// Top Left Indent
		verticesPoly[18] -= speed * 0.237; // go left X
		verticesPoly[19] -= speed * 0.24; // go up Y

	}
	
	public void pulsating() {
		pulsatingCounter++;
//		System.out.println("pulsatingCounter: " + pulsatingCounter);
		System.out.println("speed: " + speed);
//		if(pulsatingCounter > 500 && pulsatingOnce == 0){
//			speed = -speed;
//			pulsatingOnce++;
//		}else if(pulsatingCounter > 1000 && pulsatingOnce == 1){
//			speed = -speed;
//			pulsatingOnce++;
//		}
		
		if(pulsatingCounter == 400){
			speed = -0.6;
			
		}else if(pulsatingCounter == 1){
			speed = 0.3;
		}else if(pulsatingCounter == 500) {
			pulsatingCounter = 0;
		}
		// Top
		verticesPoly[0] += speed * 0.01; // go right X
		verticesPoly[1] -= speed * 0.98; // go up Y

		// Top Right Indent
		verticesPoly[2] += speed * 0.257; // go right X
		verticesPoly[3] -= speed * 0.24; // go up Y

		// Right
		verticesPoly[4] += speed * 1; // go right X
		verticesPoly[5] -= speed * 0.22; // go up Y

		// Bottom Right Indent
		verticesPoly[6] += speed * 0.41; // go right X
		verticesPoly[7] += speed * 0.25; // go down Y

		// Bottom Right
		verticesPoly[8] += speed * 0.62; // go right X
		verticesPoly[9] += speed * 1; // go down Y

		// Bottom Indent
		verticesPoly[10] += speed * 0.01; // go right X
		verticesPoly[11] += speed * 0.56; // go down Y

		// Bottom Left
		verticesPoly[12] -= speed * 0.60; // go left X
		verticesPoly[13] += speed * 1; // go down Y

		// Bottom Left Indent
		verticesPoly[14] -= speed * 0.39; // go left X
		verticesPoly[15] += speed * 0.25; // go down Y

		// Left
		verticesPoly[16] -= speed * 0.98; // go left X
		verticesPoly[17] -= speed * 0.22; // go up Y

		// Top Left Indent
		verticesPoly[18] -= speed * 0.237; // go left X
		verticesPoly[19] -= speed * 0.24; // go up Y

	}
	
	public void staticStar(int x, int y, float w, float h, double rotation, double s, double color, double puls, float singleRotation) {

		if (once == 0) {
			System.out.println("5 static star entered");
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
			float[] vertices = { x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x,
					y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour, x, y, z, colour };
			float[] verticesStar = { x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y };
			this.verticesMesh = vertices;
			this.verticesPoly = verticesStar;

			this.speed = s;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			this.singleRotation = singleRotation;

			polyStatic();
			once++;
		}

		// Star Polygon
		

		// Image
//		rectBounds.set(rectX, rectY, width, height);
//
//		rectX -= speed;
//		rectY -= speed;
//		width += speed * 2;
//		height += speed * 2;
		
		// Update Indices once after grow()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}
	
	public void polyStatic() {
		// Top
		verticesPoly[0] += width * 0.01; // go right X
		verticesPoly[1] -= width * 0.98; // go up Y

		// Top Right Indent
		verticesPoly[2] += width * 0.257; // go right X
		verticesPoly[3] -= width * 0.24; // go up Y

		// Right
		verticesPoly[4] += width * 1; // go right X
		verticesPoly[5] -= width * 0.22; // go up Y

		// Bottom Right Indent
		verticesPoly[6] += width * 0.41; // go right X
		verticesPoly[7] += width * 0.25; // go down Y

		// Bottom Right
		verticesPoly[8] += width * 0.62; // go right X
		verticesPoly[9] += width * 1; // go down Y

		// Bottom Indent
		verticesPoly[10] += width * 0.01; // go right X
		verticesPoly[11] += width * 0.56; // go down Y

		// Bottom Left
		verticesPoly[12] -= width * 0.60; // go left X
		verticesPoly[13] += width * 1; // go down Y

		// Bottom Left Indent
		verticesPoly[14] -= width * 0.39; // go left X
		verticesPoly[15] += width * 0.25; // go down Y

		// Left
		verticesPoly[16] -= width * 0.98; // go left X
		verticesPoly[17] -= width * 0.22; // go up Y

		// Top Left Indent
		verticesPoly[18] -= width * 0.237; // go left X
		verticesPoly[19] -= width * 0.24; // go up Y

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

		// Left
		verticesMesh[20] = poly.getTransformedVertices()[10]; // go left X
		verticesMesh[21] = poly.getTransformedVertices()[11]; // go up Y

		// Left
		verticesMesh[24] = poly.getTransformedVertices()[12]; // go left X
		verticesMesh[25] = poly.getTransformedVertices()[13]; // go up Y

		// Left
		verticesMesh[28] = poly.getTransformedVertices()[14]; // go left X
		verticesMesh[29] = poly.getTransformedVertices()[15]; // go up Y

		// Left
		verticesMesh[32] = poly.getTransformedVertices()[16]; // go left X
		verticesMesh[33] = poly.getTransformedVertices()[17]; // go up Y

		// Left
		verticesMesh[36] = poly.getTransformedVertices()[18]; // go left X
		verticesMesh[37] = poly.getTransformedVertices()[19]; // go up Y
		return verticesMesh;
	}
}
