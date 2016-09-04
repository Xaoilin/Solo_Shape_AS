package com.xaoilin.SSHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class ReadFiles {

	//Reads LevelTargets and returns array for 3 star achievement for a given level
	public int[] readStarTargets(int level){
		FileHandle file = Gdx.files.internal("data/text_files/LevelTargets");
		int[] targetStars = new int[3];
		String text = file.readString();
		String[] parts = text.split("!");

		//Search through every level
		for(int i = 0; i < parts.length; i++){
			
			//Find the level specified in parameters
			if(parts[i].contains(level + ":")){

				//Remove the level "1:" sub text
				String rmLevel[] = parts[i].split(level +":");

				//Split into 3 values
				String targetParts[] = rmLevel[1].split(",");
				for(int j = 0; j < targetParts.length; j++){

					//Convert to Integers and populate array
					int ex = Integer.parseInt(targetParts[j].replaceAll("\\s", ""));
					targetStars[j] = ex;
				}
				break; //Exit loop once the level is found
			}
		}
		
		return targetStars;
		
	}
	
}
