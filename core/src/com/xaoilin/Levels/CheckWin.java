package com.xaoilin.Levels;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.Helper;

public class CheckWin {

	public static String gameOverMessage = "";
	public Shapes myShapes;

	public CheckWin(Shapes shapes) {
		this.myShapes = shapes;
	}

	public void reset(int lossMessage) {
		myShapes.setClickCounter(0);
		myShapes.setAlive(false);
		System.out.println("RESET");
	}
	
	public boolean overlapsMultiplePolygons(Polygon polygon, int[] polygons){
		for (int i = 0; i < polygons.length; i++) {
			if(overlapsPolygon(polygon, Shapes.polyShapes[polygons[i]])){
				return true;
			}
		}
		return false;
	}

	public boolean overlapsCircle(Polygon polygon, Circle circle) {
		float[] vertices = polygon.getTransformedVertices();
		Vector2 center = new Vector2(circle.x, circle.y);
		float squareRadius = circle.radius * circle.radius;
		for (int i = 0; i < vertices.length; i += 2) {
			if (i == 0) {
				if (Intersector.intersectSegmentCircle(
						new Vector2(vertices[vertices.length - 2], vertices[vertices.length - 1]),
						new Vector2(vertices[i], vertices[i + 1]), center, squareRadius))
					return true;
			} else {
				if (Intersector.intersectSegmentCircle(new Vector2(vertices[i - 2], vertices[i - 1]),
						new Vector2(vertices[i], vertices[i + 1]), center, squareRadius))
					return true;
			}
		}
		return false;
	}

	/**
	 * If two polygons grow apart from each other, it will return true when they
	 * collide
	 * If poly2 grows inside of poly1, it will return true when they
	 * collide
	 * 
	 * @param poly1
	 * @param poly2
	 * @return
	 */
	public boolean overlapsPolygon(Polygon poly1, Polygon poly2) {
		float[] vertices = poly1.getTransformedVertices();

		for (int i = 0; i < vertices.length; i += 2) {
			if (i == 0) {
				if (Intersector.intersectSegmentPolygon(
						new Vector2(vertices[vertices.length - 2], vertices[vertices.length - 1]),
						new Vector2(vertices[i], vertices[i + 1]), poly2))
					return true;
			} else {
				if (Intersector.intersectSegmentPolygon(new Vector2(vertices[i - 2], vertices[i - 1]),
						new Vector2(vertices[i], vertices[i + 1]), poly2))
					return true;
			}
		}
		return false;
	}

}
