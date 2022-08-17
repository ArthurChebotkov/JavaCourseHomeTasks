package model;

import model.items.Brick;
import model.items.Coin;
import model.items.Floor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapModel{

    public static final int DEFAULT_WIDTH = 37;
    public static final int DEFAULT_HEIGHT = 14;

    private Character[][] map;

    private ArrayList<Brick> wall;
    private ArrayList<Floor> listFloor;
    private ArrayList<Coin> coins;


    public MapModel (String pathToFile) throws IOException {
        this.map = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        this.wall = new ArrayList<Brick>();
        this.listFloor = new ArrayList<Floor>();
        this.coins = new ArrayList<Coin>();
        this.parseMap(pathToFile);
        this.parseMapToItems(pathToFile);
    }


    private void parseMap(String pathToFile) throws IOException {
        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        int indexLine = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int j = 0; j < this.map[0].length; j++) {
                this.map[indexLine][j] = line.charAt(j);
            }
            indexLine++;
        }
        reader.close();
    }

    private void parseMapToItems(String pathToFile) throws IOException {
        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        int indexLine = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int j = 0; j < this.map[0].length; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        this.wall.add(new Brick(new Position(j,indexLine)));
                        break;
                    case '.':
                        this.listFloor.add(new Floor(new Position(j,indexLine)));
                        break;
                    case '$':
                        this.coins.add(new Coin(new Position(j,indexLine)));
                        break;
                    default:
                        break;
                }
            }
            indexLine++;
        }
        reader.close();
    }

    public Character[][] makeMapCopy() {
        Character[][] mapCopy = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        for(int i = 0; i<this.map.length; i++) {
            for(int j = 0; j<this.map[0].length; j++) {
                mapCopy[i][j] = this.map[i][j];
            }
        }
        return mapCopy;
    }

    public boolean hasCollision (Position target) {
        for (Brick brick: wall) {
            if (target.getX() == brick.position.getY() && target.getY() == brick.position.getX() ) {
                return false;
            }
        }
        for (Floor floor: listFloor) {
            if (target.getX() == floor.position.getY() && target.getY() == floor.position.getX() ) {
                return false;
            }
        }
        return true;
    }
}
