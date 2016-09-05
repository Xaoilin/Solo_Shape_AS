package com.xaoilin.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Polygon;
import com.xaoilin.GameObjects.Circles;
import com.xaoilin.GameObjects.FiveStar;
import com.xaoilin.GameObjects.Pentagon;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameObjects.Snowflake;
import com.xaoilin.GameObjects.Square;
import com.xaoilin.GameObjects.Triangle;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.SSHelpers.AssetLoader;

import java.util.ArrayList;

public class Helper {

	OrthographicCamera cam;
	short[] ex;
	public static Mesh mesh;
	public static EarClippingTriangulator earclip;


	Sprite blackCircles[] = new Sprite[Shapes.SHAPES_SIZE];
	Sprite whiteCircles[] = new Sprite[Shapes.SHAPES_SIZE];

	Sprite imageSprite;
	public static SpriteBatch batch;
	public static ShapeRenderer shapeRenderer;
	String vertexShader;
	String fragmentShader;
	ShaderProgram shaderProgram;
	float[] tri, tri2, triShort, star;

	// Game Objects
	Shapes myShapes;
	LevelFiles myLevelFiles;
	GameWorld myWorld;

	PolygonSprite polySprite, polyWhiteSprite;
	PolygonSpriteBatch polyBatch;
	PolygonRegion polyReg = null;
	Texture blackT, whiteT, blueT, goldT, forestT, salmonT;
	TextureRegion blackTexture, whiteTexture, blueTexture, goldTexture, forestTexture, salmonTexture;

	int gameWidth;
	int gameHeight;

	public Helper(GameWorld myWorld) {
		int x = 1080 / 2;
		int y = 1920 / 2;
		star = new float[] { x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y };

		this.myShapes = myWorld.getShapes();
		this.myLevelFiles = myWorld.getLevelFiles();
		this.myWorld = myWorld;
		this.gameHeight = GameWorld.gameHeight;
		this.gameWidth = GameWorld.gameWidth;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, this.gameWidth, this.gameHeight);


		earclip = new EarClippingTriangulator();
		polyBatch = new PolygonSpriteBatch();
		polyBatch.setProjectionMatrix(cam.combined);
		polyBatch.totalRenderCalls = 0;
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		// Set Shader for Mesh
		vertexShader = Gdx.files.internal("data/text_files/vertex.glsl").readString();
		fragmentShader = Gdx.files.internal("data/text_files/shader.glsl").readString();
		shaderProgram = new ShaderProgram(vertexShader, fragmentShader);
		// x y z for Usage.position
		// true, 3, 3 means static, max vertices, max indices
		// mesh = new Mesh(true, 100, 100, new VertexAttribute(Usage.Position,
		// 3, "a_position"),
		// new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
		mesh = new Mesh(true, 500, 500, new VertexAttribute(Usage.Position, 2, "a_position"));
		initAssets();
	}

	public void initAssets() {
		for (int i = 0; i < Shapes.SHAPES_SIZE; i++) {
			blackCircles[i] = new Sprite(AssetLoader.blackCircle);
			whiteCircles[i] = new Sprite(AssetLoader.whiteCircle);
		}
		imageSprite = new Sprite(AssetLoader.snowflake);
		Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA4444);
		pix.setColor(Color.BLACK);
		pix.fill();

		blackT = new Texture(pix);
		blackTexture = new TextureRegion(blackT);
		pix.setColor(Color.WHITE);
		pix.fill();

		whiteT = new Texture(pix);
		whiteTexture = new TextureRegion(whiteT);



	}

	public void drawInstructions(int gameLevel) {

		switch (gameLevel) {
			case 1:
				if (myShapes.getClickCounterInstructions() == 1) {
					drawText("TAP ANYWHERE", (gameWidth * 0.1343), gameHeight * 0.1719, 0);
					drawText("TO STOP THE", (gameWidth * 0.1537), gameHeight * 0.3281, 0);
					drawText("SHAPES FROM", (gameWidth * 0.155), (gameHeight * 0.4844), 0);
					drawText("EXPANDING!", (gameWidth * 0.1911), (gameHeight * 0.6406), 0);
				} else if (myShapes.getClickCounterInstructions() == 2) {
					drawText("DON'T LET THE", (gameWidth * 0.0737), (gameHeight * 0.1719), 0);
					drawText("SHAPES TOUCH", (gameWidth * 0.09556), (gameHeight * 0.3281), 0);
					drawText("THE EDGE OF", (gameWidth * 0.1228), (gameHeight * 0.4844), 0);
					drawText("THE SCREEN!", (gameWidth * 0.1330), (gameHeight * 0.6406), 0);
				}
				break;
			case 3:
				if (myShapes.getClickCounterInstructions() == 1) {
					drawText("SHAPES CAN", (gameWidth * 0.1524), (gameHeight * 0.2719), 0);
					drawText("GROW INSIDE", (gameWidth * 0.1330), (gameHeight * 0.4281), 0);
					drawText("EACH OTHER!", (gameWidth * 0.1430), (gameHeight * 0.5844), 0);
				}
				break;
			case 5:
				if (myShapes.getClickCounterInstructions() == 1) {
					drawText("SHAPES CAN", (gameWidth * 0.1624), (gameHeight * 0.2719), 0);
					drawText("ROTATE TOO!", (gameWidth * 0.1480), (gameHeight * 0.4281), 0);
					drawText("GOOD LUCK!", (gameWidth * 0.1793), (gameHeight * 0.5844), 0);
				}
				break;
			default:
				Gdx.app.log("Null", "No Instructions to be drawn");
				break;
		}

	}

//	public void drawFourStar(FourStar shape, Polygon[] poly) {
//		//Draw Image
//		batch.begin();
//		batch.draw(AssetLoader.fourStar, shape.rectX, shape.rectY, shape.width, shape.height);
//		batch.end();
//
//		// SET Polygon
//		poly[shape.id].setVertices(shape.verticesPoly);
//		if (shape.rotation > 0) {
//			poly[shape.id].rotate((float) shape.rotation);
//			poly[shape.id].setOrigin(shape.originX, shape.originY);
//		}else if(shape.singleRotation > 0){
//			poly[shape.id].setRotation(shape.singleRotation);
//			poly[shape.id].setOrigin(shape.originX, shape.originY);
//		}
//
//		// DRAW Polygon with Mesh
//		shaderProgram.begin();
//		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
//		if (shape.color == 0)
//			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
//		if (shape.color == 1)
//			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
//		if (shape.color == 2)
//			shaderProgram.setAttributef("a_color", 100, 0, 0, 255);
//		mesh.setVertices(poly[shape.id].getTransformedVertices());
//		mesh.setIndices(shape.indices);
//		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
//		shaderProgram.end();
//
//		// Outline
//		shapeRenderer.begin(ShapeType.Line);
//		if (shape.color == 0)
//			shapeRenderer.setColor(Color.WHITE);
//		if (shape.color == 1)
//			shapeRenderer.setColor(Color.BLACK);
//		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
//		shapeRenderer.end();
//	}

	public void drawSnowflake(Snowflake shape, Polygon[] poly) {
		// SET Polygon
		poly[shape.id].setVertices(shape.verticesPoly);
		if (shape.rotation > 0) {
			poly[shape.id].rotate((float) shape.rotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}else if(shape.singleRotation > 0){
			poly[shape.id].setRotation(shape.singleRotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}

		// DRAW Polygon with Mesh
		shaderProgram.begin();
		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
		if (shape.color == 0)
			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
		if (shape.color == 1)
			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
		if (shape.color == 2)
			shaderProgram.setAttributef("a_color", 100, 0, 0, 255);
		mesh.setVertices(poly[shape.id].getTransformedVertices());
		mesh.setIndices(shape.indices);
		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();

		// Outline
		shapeRenderer.begin(ShapeType.Line);
		if (shape.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (shape.color == 1)
			shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
		shapeRenderer.end();
	}

	public void drawPentagon(Pentagon shape, Polygon[] poly) {

		poly[shape.id].setVertices(shape.verticesPoly);
		if (shape.rotation > 0) {
			poly[shape.id].rotate((float) shape.rotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}else if(shape.singleRotation > 0){
			poly[shape.id].setRotation(shape.singleRotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}

		// DRAW Polygon with Mesh
		shaderProgram.begin();
		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
		if (shape.color == 0)
			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
		if (shape.color == 1)
			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
		if (shape.color == 2)
			shaderProgram.setAttributef("a_color", 100, 0, 0, 255);
		mesh.setVertices(poly[shape.id].getTransformedVertices());
		mesh.setIndices(shape.indices);
		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();

		// Outline
		shapeRenderer.begin(ShapeType.Line);
		if (shape.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (shape.color == 1)
			shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
		shapeRenderer.end();
	}

	public void drawTriangle(Triangle shape, Polygon[] poly) {

		// SET Polygon
		poly[shape.id].setVertices(shape.verticesPoly);
		if (shape.rotation > 0) {
			poly[shape.id].rotate((float) shape.rotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}else if(shape.singleRotation > 0){

			poly[shape.id].setRotation(shape.singleRotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}

		// DRAW Polygon with Mesh
		shaderProgram.begin();
		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
		if (shape.color == 0)
			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
		if (shape.color == 1)
			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
		if (shape.color == 2)
			shaderProgram.setAttributef("a_color", 100, 0, 0, 255);
		mesh.setVertices(poly[shape.id].getTransformedVertices());
		mesh.setIndices(shape.indices);
		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();

		// DRAW Outline
		shapeRenderer.begin(ShapeType.Line);
		if (shape.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (shape.color == 1)
			shapeRenderer.setColor(Color.BLACK);

		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
		shapeRenderer.end();
	}

	public void drawFiveStar(FiveStar shape, Polygon[] poly) {
		poly[shape.id].setVertices(new float[20]);
		// SET Polygon
		poly[shape.id].setVertices(shape.verticesPoly);
		if (shape.rotation > 0) {
			poly[shape.id].rotate((float) shape.rotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}else if(shape.singleRotation > 0){
			poly[shape.id].setRotation(shape.singleRotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}

		// DRAW Polygon with Mesh
		shaderProgram.begin();
		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
		if (shape.color == 0)
			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
		if (shape.color == 1)
			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
		if (shape.color == 2)
			shaderProgram.setAttributef("a_color", 255, 0, 0, 255);
		mesh.setVertices(poly[shape.id].getTransformedVertices());
		mesh.setIndices(shape.indices);
		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();

		// DRAW Outline
		shapeRenderer.begin(ShapeType.Line);
		if (shape.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (shape.color == 1)
			shapeRenderer.setColor(Color.BLACK);
//		if (shape.color == 0)
//			shapeRenderer.setColor(Color.RED);
		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
		shapeRenderer.end();
	}

	public void drawCircle(Circles circ, int num,  Polygon[] poly) {
//		System.out.println("drawing cirlce: " + circ.circleBounds);
		batch.begin();

		if (circ.color == 0) {
			blackCircles[num].setBounds(circ.rectX, circ.rectY, circ.width, circ.height);
			blackCircles[num].draw(batch);
		} else if (circ.color == 1) {
			whiteCircles[num].setBounds(circ.rectX, circ.rectY, circ.width, circ.height);
			whiteCircles[num].setColor(Color.WHITE);
			whiteCircles[num].draw(batch);
		} else if(circ.color == 2){
			whiteCircles[num].setBounds(circ.rectX, circ.rectY, circ.width, circ.height);
			whiteCircles[num].setColor(Color.RED);
			whiteCircles[num].draw(batch);
		}
		batch.end();

		shapeRenderer.begin(ShapeType.Line);
		if (circ.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (circ.color == 1)
			shapeRenderer.setColor(Color.BLACK);
		if (circ.color == 2)
			shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.circle(circ.circleBounds.x, circ.circleBounds.y, circ.circleBounds.radius);
		shapeRenderer.end();

//		 System.out.println("circle bounds: " + circ.circleBounds);
	}


	public void drawSquare(Square shape, Polygon[] poly) {
		// SET Polygon
		poly[shape.id].setVertices(shape.verticesPoly);
		if (shape.rotation > 0) {
			poly[shape.id].rotate((float) shape.rotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}else if(shape.singleRotation > 0){
			poly[shape.id].setRotation(shape.singleRotation);
			poly[shape.id].setOrigin(shape.originX, shape.originY);
		}

		// DRAW Polygon with Mesh
		shaderProgram.begin();
		shaderProgram.setUniformMatrix("u_worldView", batch.getProjectionMatrix());
		if (shape.color == 0)
			shaderProgram.setAttributef("a_color", 0, 0, 0, 255);
		if (shape.color == 1)
			shaderProgram.setAttributef("a_color", 255, 255, 255, 255);
		if (shape.color == 2)
			shaderProgram.setAttributef("a_color", 100, 0, 0, 255);
		mesh.setVertices(poly[shape.id].getTransformedVertices());
		mesh.setIndices(shape.indices);
		mesh.render(shaderProgram, GL20.GL_TRIANGLES);
		shaderProgram.end();

		// DRAW Outline
		shapeRenderer.begin(ShapeType.Line);
		if (shape.color == 0)
			shapeRenderer.setColor(Color.WHITE);
		if (shape.color == 1)
			shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.polygon(poly[shape.id].getTransformedVertices());
		shapeRenderer.end();
	}



	public void drawScore() {
		String score = myWorld.getScore() + "";
		double scale = gameWidth * 0.02777778;

		batch.begin();
		AssetLoader.blackFont.draw(batch, score, (int) ((gameWidth * 0.4459) - ((score.length() - 1) * scale)),
				(int) (gameHeight * 0.0260) - 1);
		batch.end();
	}

	/**
	 * @param colour
	 *            0 for black 1 for white
	 */
	public void drawText(String text, double x, double y, int colour) {
		batch.begin();
		if (colour == 0) {
			AssetLoader.blackFont.draw(batch, text, (int) x - 1, (int) y - 1);
		} else if (colour == 1) {
			AssetLoader.whiteFont.draw(batch, text, (int) x - 1, (int) y - 1);
		} else if (colour == 2) {
			AssetLoader.redFont.setColor(0, 0, 255, 1);
			AssetLoader.redFont.getData().setScale(3f, -3f);
			AssetLoader.redFont.draw(batch, text, (int) x - 1, (int) y - 1);

		}else if (colour == 5) {
			AssetLoader.continueBlackFont.draw(batch, text, (int) x - 1, (int) y - 1);
		} else if (colour == 6) {
			AssetLoader.continueWhiteFont.draw(batch, text, (int) x - 1, (int) y - 1);
		} else {
			System.out.println("Invalid Text Colour");
		}

		batch.end();
	}

	/**
	 * For fixed images
	 */
	public void drawTexture(double x, double y, double scale, TextureRegion texture) {
		batch.begin();
		batch.draw(texture, (float) x, (float) y, (float) (texture.getRegionWidth() * scale),
				(float) (texture.getRegionHeight() * scale));
		batch.end();
	}

	/**
	 * For images with varying dimensions
	 */
	public void drawTexture(double x, double y, double size, TextureRegion texture, boolean empty) {
		batch.begin();
		batch.draw(texture, (float) x, (float) y, (float) (size), (float) (size));
		batch.end();
	}

	public void drawTexture(double x, double y, double scale, Texture texture) {
		batch.begin();
		batch.draw(texture, (float) x, (float) y, (float) (texture.getWidth() * scale),
				(float) (texture.getHeight() * scale));
		batch.end();
	}

	public void drawTargetStars(ArrayList<int[]> target, double scale) {
		// 1 Star
		drawText(target.get(myLevelFiles.getLevel() - 1)[0] + "", (gameWidth * 0.1667), (gameHeight * 0.3142), 0);
		drawTexture((gameWidth * 0.4370), (gameHeight * 0.2962), scale, AssetLoader.yesStar);

		// 2 Star
		drawText(target.get(myLevelFiles.getLevel() - 1)[1] + "", (gameWidth * 0.1667), (gameHeight * 0.5142), 0);
		drawTexture((gameWidth * 0.4370), (gameHeight * 0.4962), scale, AssetLoader.yesStar);
		drawTexture((gameWidth * 0.5870), (gameHeight * 0.4962), scale, AssetLoader.yesStar);

		// 3 Star
		drawText(target.get(myLevelFiles.getLevel() - 1)[2] + "", (gameWidth * 0.1667), (gameHeight * 0.7142), 0);
		drawTexture((gameWidth * 0.4370), (gameHeight * 0.6962), scale, AssetLoader.yesStar);
		drawTexture((gameWidth * 0.5870), (gameHeight * 0.6962), scale, AssetLoader.yesStar);
		drawTexture((gameWidth * 0.7370), (gameHeight * 0.6962), scale, AssetLoader.yesStar);
	}


	public void resetVariables() {
		blackT.dispose();
		whiteT.dispose();
		initAssets();

	}

}
