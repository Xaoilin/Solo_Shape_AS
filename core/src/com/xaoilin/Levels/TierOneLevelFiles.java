package com.xaoilin.Levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class TierOneLevelFiles extends LevelFiles {

    public static ArrayList<int[]> polyInteractions = new ArrayList<int[]>();

    public TierOneLevelFiles() {
        super();
    }

    // TYPE 1 Circle, 2 Square, 3 Triangle, 4 Four Star, 5 (5 Star), 6 Pentagon, 7 Snowflake, 8
    // Paramaters are: "Type, X, Y, Width, Height, Continuous Rotation, Speed, Colour, Pulsating, Single Rotation"

    public void file(int gameLvl) {

        switch (gameLvl) {

            case 1:
                Level1(fileArray, gameLvl);
                break;
            case 2:
                Level2(fileArray, gameLvl);
                break;
            case 3:
                Level3(fileArray, gameLvl);
                break;
            case 4:
                Level4(fileArray, gameLvl);
                break;
            case 5:
                Level5(fileArray, gameLvl);
                break;
            case 6:
                Level6(fileArray, gameLvl);
                break;
            case 7:
                Level7(fileArray, gameLvl);
                break;
            case 8:
                Level8(fileArray, gameLvl);
                break;
            case 9:
                Level9(fileArray, gameLvl);
                break;
            case 10:
                Level10(fileArray, gameLvl);
                break;
            case 11:
                Level11(fileArray, gameLvl);
                break;
            case 12:
                Level12(fileArray, gameLvl);
                break;
            case 13:
                Level13(fileArray, gameLvl);
                break;
            case 14:
                Level14(fileArray, gameLvl);
                break;
            case 15:
                Level15(fileArray, gameLvl);
                break;
            case 16:
                Level16(fileArray, gameLvl);
                break;
            case 17:
                Level17(fileArray, gameLvl);
                break;
            case 18:
                Level18(fileArray, gameLvl);
                break;
            case 19:
                Level19(fileArray, gameLvl);
                break;
            case 20:
                Level20(fileArray, gameLvl);
                break;
            default:
                Gdx.app.log("ERROR", "TierOneLevelFiles Class, File method");
                break;
        }

    }

    private void ExLevel14(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("5, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.3, 0, 1, 0\n, "

                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void ExLevel13(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;

        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);

        FileHandle fileObstacles = Gdx.files.local("Level" + gameLvl + "Obstacles.txt");
        fileObstacles.writeString("5, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 300, 0, 1, 0.2, 2, 0, 0\n, "
                , false);


        fileObstacleArray = fileObstacles.readString().split(", ");

        int numberOfShapes2 = fileObstacleArray.length / rowParams;

        obstacleArray = new float[numberOfShapes2][rowParams];
        obstacleArray = createArray(numberOfShapes2, fileObstacleArray);

        fileLevelName = file.name();
    }


    private void Level20(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 3.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 7.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.4, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.5, 1, 0, 0\n, ", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level19(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.6, 0, 0, 0\n, "

                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "

                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                        + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level18(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 1, 0, 0\n, "
                + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.3, 0, 0, 0", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();

    }

    private void Level17(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level16(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 0, 0.55, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 0, 0.65, 1, 0, 0\n, "
                        + "5, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 0, 0.75, 0, 0, 0\n, "
                        + "6, " + (gameWidth / 10) * 8 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 0, 0.85, 1, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 2 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 1, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 1, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 1, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.95, 1, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.9, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.9, 1, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.9, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5.5 + ", 0, 0, 1, 0.9, 1, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level15(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 2 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 9 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 9 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                        + "2, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 0, 0.4, 0, 0, 0\n, "
                        + "6, " + (gameWidth / 10) * 1 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "3, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "5, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 3 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "6, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 4 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "3, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "5, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "6, " + (gameWidth / 10) * 7 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "3, " + (gameWidth / 10) * 5 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 8 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "5, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 7 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                        + "6, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 6 + ", 0, 0, 1, 0.15, 0, 0, 0\n, "
                        + "3, " + (gameWidth / 10) * 3 + ", " + (gameHeight / 10) * 5 + ", 0, 0, 1, 0.3, 0, 0, 0\n, "
                , false);

        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level14(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 0, 0.8, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 1.1, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 1, 0.7, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 1.3, 0, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 1.6, 0, 0, 0\n", false);


        fileArray = file.readString().split(", ");
        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);

        fileLevelName = file.name();
    }

    private void Level13(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 0, 1.2, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 1.2, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 1, 1.2, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 1.2, 0, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 0.6, 0, 0, 0\n", false);


        fileArray = file.readString().split(", ");
        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);

        fileLevelName = file.name();
    }

    private void Level12(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("5, " + (gameWidth / 4) * 3.15 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 1, 0.4, 0, 0, 0\n, "
                + "5, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 0.4, 0, 0, 0\n, "
                + "5, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 1, 0.4, 0, 0, 0\n, "
                + "5, " + (gameWidth / 4) * 3.15 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 0.4, 0, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 0.4, 0, 0, 0\n, "
                + "2, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 0.4, 1, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 0.4, 0, 0, 0\n", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level11(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("1, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 1, 1, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 1, 0.3, 1, 0, 0\n, ", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }


    private void Level10(String[] fileArray, int gameLvl) {


        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("5, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 0, 0, 0\n, "
                + "5, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1, 0, 0\n", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level9(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");

        file.writeString("2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.37 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.62 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.34 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.48 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.62 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.76 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.62 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.37 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.76 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.62 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.48 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.34 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "7, " + (gameWidth) * 0.5 + ", " + (gameHeight) * 0.4 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.37 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.62 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.2 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.34 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.48 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.62 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.76 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.88 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.62 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.37 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.90 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.76 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.62 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.48 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "2, " + (gameWidth) * 0.12 + ", " + (gameHeight) * 0.34 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "7, " + (gameWidth) * 0.5 + ", " + (gameHeight) * 0.65 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level8(String[] fileArray, int gameLvl) {


        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("4, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth) * 0.2 + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth) * 0.83 + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 2) + ", " + (gameHeight) * 0.3 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 2) + ", " + (gameHeight) * 0.7 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.15) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.38) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.61) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.85) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "4, " + (gameWidth) * 0.85 + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth) * 0.61 + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.38) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.15) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "1, " + (gameWidth * 0.5) + ", " + (gameHeight) * 0.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.2) + ", " + (gameHeight) * 0.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.83) + ", " + (gameHeight) * 0.5 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.5) + ", " + (gameHeight) * 0.3 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.5) + ", " + (gameHeight) * 0.7 + ", 0, 0, 0, 0.3, 1, 0, 0\n, "
                        + "4, " + (gameWidth * 0.5) + ", " + (gameHeight) * 0.5 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level7(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("2, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.9, 0, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.7, 1, 0, 0\n, "
                + "3, " + gameWidth / 2 + ", " + (gameHeight / 2) * 0.89 + ", 0, 0, 0, 0.7, 0, 0, 0", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level6(String[] fileArray, int gameLvl) {


        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("4, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth) * 0.2 + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth) * 0.83 + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 2) + ", " + (gameHeight) * 0.3 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth / 2) + ", " + (gameHeight) * 0.7 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.15) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.38) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.61) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                        + "1, " + (gameWidth * 0.85) + ", " + (gameHeight) * 0.9 + ", 0, 0, 0, 0.3, 0, 0, 0\n, "
                , false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }


    private void Level5(String[] fileArray, int gameLvl) {
        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("3, " + (gameWidth * 0.9) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.2, 0, 0, 90\n, "
                + "3, " + (gameWidth * 0.1) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.2, 0, 0, 270\n, "
                + "2, " + (gameWidth * 0.29) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth * 0.71) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "1, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight * 0.62) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight * 0.38) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight * 0.72) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight * 0.28) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + (gameWidth / 2) + ", " + (gameHeight * 0.82) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "3, " + (gameWidth / 2) + ", " + (gameHeight * 0.18) * 1 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "3, " + (gameWidth / 2) + ", " + (gameHeight * 0.93) * 1 + ", 0, 0, 0, 0.2, 0, 0, 180\n, ", false);


        fileArray = file.readString().split(", ");
        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);

        fileLevelName = file.name();
    }

    private void Level4(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 0, 0.9, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 0.9, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 1 + ", " + (gameHeight / 4) * 1 + ", 0, 0, 1, 0.9, 0, 0, 0\n, "
                + "1, " + (gameWidth / 4) * 3 + ", " + (gameHeight / 4) * 3 + ", 0, 0, 1, 0.9, 0, 0, 0\n, "
                + "1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 1, 0.9, 0, 0, 0\n", false);


        fileArray = file.readString().split(", ");
        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);

        fileLevelName = file.name();
    }


    private void Level3(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("2, " + gameWidth * 0.25 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.86 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + gameWidth * 0.75 + ", " + gameHeight * 0.58 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + gameWidth * 0.25 + ", " + gameHeight * 0.30 + ", 0, 0, 0, 0.2, 0, 0, 0\n, "
                + "2, " + gameWidth * 0.75 + ", " + (gameHeight) * 0.30 + ", 0, 0, 0, 0.2, 0, 0, 0", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level2(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("2, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 1, 0, 0.7, 0, 0, 0", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
    }

    private void Level1(String[] fileArray, int gameLvl) {

        FileHandle file = Gdx.files.local("Level" + gameLvl + ".txt");
        file.writeString("6, " + (gameWidth / 2) + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.35, 0, 0, 0", false);


        fileArray = file.readString().split(", ");

        int numberOfShapes = fileArray.length / rowParams;
        levelArray = new float[numberOfShapes][rowParams];
        levelArray = createArray(numberOfShapes, fileArray);
        fileLevelName = file.name();
        ShowArray(levelArray);
    }


}
