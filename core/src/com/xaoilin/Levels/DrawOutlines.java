package com.xaoilin.Levels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;
import com.xaoilin.GameObjects.Circles;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameObjects.Square;
import com.xaoilin.GameWorld.GameWorld;

public class DrawOutlines {
	Shapes myShapes;
	GameWorld myWorld;
	float gameHeight;
	float gameWidth;
	OrthographicCamera cam;
	ShapeRenderer shapeRenderer;
	Polygon[] poly = new Polygon[50];
	
	public DrawOutlines(GameWorld myWorld) {
		this.myShapes = myWorld.getShapes();
		this.myWorld = myWorld;
		this.gameHeight = GameWorld.gameHeight;
		this.gameWidth = GameWorld.gameWidth;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, this.gameWidth, this.gameHeight);

		// Populate batch and polygon
		for (int i = 0; i < poly.length; i++) {
			poly[i] = new Polygon();
		}

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	
	public void drawCircle(Circles circ, int num) {

		 shapeRenderer.begin(ShapeType.Line);
		 shapeRenderer.setColor(Color.RED);
		 shapeRenderer.circle(circ.circleBounds.x,
		 circ.circleBounds.y, circ.circleBounds.radius);
		 shapeRenderer.circle(circ.circleBounds.x,
				 circ.circleBounds.y, (float) (circ.circleBounds.radius * 1.1));
		 shapeRenderer.end();

		 System.out.println("circle bounds: " + circ.circleBounds);
	}

	public void drawRectangle(Square square, int num) {

		 shapeRenderer.begin(ShapeType.Line);
		 shapeRenderer.setColor(Color.RED);
		 shapeRenderer.rect(square.rectBounds.x, square.rectBounds.y, square.width, square.height);
		 shapeRenderer.rect((float) (square.rectBounds.x*0.97),(float) (square.rectBounds.y * 0.99),(float) (square.rectBounds.width * 1.1),(float) (square.rectBounds.height * 1.1));
		 shapeRenderer.end();

//		 System.out.println("circle bounds: " + circ.circleBounds);
	}
	
}
