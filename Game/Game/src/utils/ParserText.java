package utils;

import model.Position;
import model.entities.Thorn;
import model.entities.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ParserText implements Parser{
    public static final int DEFAULT_WIDTH = 37;
    public static final int DEFAULT_HEIGHT = 15;
    public ParserText() {
    }


    public Character[][] parseMapTerrainToArray(String pathToFile) throws IOException {
        Character[][] map = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        int indexLine = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int j = 0; j < map[0].length; j++) {
                map[indexLine][j] = line.charAt(j);
            }
            indexLine++;
        }
        reader.close();
        return map;
    }

    public HashMap<String,ArrayList> parseMapToTerrain(String pathToFile) throws IOException {

        HashMap<String,ArrayList> hashMap = new HashMap<>();
        ArrayList<Brick> wall = new ArrayList<Brick>();
        ArrayList<Floor> lostFloor = new ArrayList<Floor>();

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        int indexLine = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int j = 0; j < DEFAULT_WIDTH; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        wall.add(new Brick(new Position(indexLine,j)));
                        break;
                    case '.':
                        lostFloor.add(new Floor(new Position(indexLine,j)));
                        break;
                    default:
                        break;
                }
            }
            indexLine++;
        }
        reader.close();

        hashMap.put("wall", wall);
        hashMap.put("listFloor", lostFloor);

        return hashMap;
    }

    public HashMap<String,ArrayList> parseMapToItems(String pathToFile) throws IOException {

        HashMap<String,ArrayList> hashMap = new HashMap<>();

        ArrayList<Coin> coins = new ArrayList<Coin>();
        ArrayList<Teleport> teleports = new ArrayList<Teleport>();
        ArrayList<Thorn> thorns = new ArrayList<Thorn>();

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        int indexLine = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int j = 0; j < DEFAULT_WIDTH; j++) {
                switch (line.charAt(j)) {
                    case '$':
                        coins.add(new Coin(new Position(indexLine,j)));
                        break;
                    case 't':
                        teleports.add(new Teleport(new Position(indexLine,j)));
                        break;
                    case 's':
                        thorns.add(new Thorn(new Position(indexLine,j)));
                        break;
                    default:
                        break;
                }
            }
            indexLine++;
        }
        reader.close();

        hashMap.put("coins", coins);
        hashMap.put("teleports", teleports);
        hashMap.put("thorns", thorns);

        return hashMap;
    }

}
