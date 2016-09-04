package com.xaoilin.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.SSHelpers.Memory;

/**
 * TO to hold item's data
 * 
 * @author Daldegan
 * 
 */
public final class Item {

	private final class ImageClick extends ClickListener {
		private Item item;
		
		public ImageClick(Item item) {
			this.item = item;
		}

		public void clicked(InputEvent event, float x, float y) {
			Gdx.app.log("SELECTED ITEM", "ID: " + item.getId() + " Description: " + item.getDescription());
			if(item.getDescription().startsWith("LevelBox") && Memory.getHighestUserLevel() > item.getId()){
				LevelFiles.gameLvl = item.getId() + 1;
				GameWorld.reset();
				GameWorld.setReady();
			}
			
		}
	}

	private int id;
	private String description;
	private Image image;
	private Color color;
	
	public final int getId() {
		return id;
	}

	public final String getDescription() {
		return description;
	}

	public final Image getImage() {
		return image;
	}

	public final Color getColor() {
		return color;
	}

	public Item(int index, String description, Texture texture, Color color, Skin skin) {
		this.id = index;
		this.description = description;
		this.image = new Image(texture);
		this.color = color;

		image.setColor(color);

		image.addListener(new ImageClick(this));
	}
	
	public Item(int index, String description, TextureRegion texture, Color color, Skin skin) {
		this.id = index;
		this.description = description;
		this.image = new Image(texture);
		this.color = color;

		image.setColor(color);
	
		image.addListener(new ImageClick(this));
	}
}
