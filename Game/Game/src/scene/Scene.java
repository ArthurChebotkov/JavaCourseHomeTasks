package scene;

import map.MapModel;
import model.entities.*;
import utils.Parser;
import utils.ParserText;

import java.io.IOException;
import java.util.ArrayList;

public class Scene {

    private MapModel mapModel;
    private ArrayList<Brick> wall;
    private ArrayList<Floor> listFloor;
    private ArrayList<Coin> coins;
    private ArrayList<Teleport> teleports;

    private ArrayList<Thorn> thorns;


    public Scene(String pathToFileLevel0, String pathToFileLevel1) throws IOException {
        Parser parser = new ParserText();
        this.mapModel = new MapModel(pathToFileLevel0);

        this.wall = parser.parseMapToItemsLevel0(pathToFileLevel0).get("wall");
        this.listFloor = parser.parseMapToItemsLevel0(pathToFileLevel0).get("listFloor");

        this.coins = parser.parseMapToItemsLevel1(pathToFileLevel1).get("coins");
        this.teleports = parser.parseMapToItemsLevel1(pathToFileLevel1).get("teleports");
        this.thorns = parser.parseMapToItemsLevel1(pathToFileLevel1).get("thorns");
    }


    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public ArrayList<Brick> getWall() {
        return wall;
    }

    public ArrayList<Teleport> getTeleports() {
        return teleports;
    }

    public ArrayList<Floor> getListFloor() {
        return listFloor;
    }

    public ArrayList<Thorn> getThorns() {
        return thorns;
    }

    public MapModel getMapModel() {
        return mapModel;
    }

/*    public ArrayList getEntityByName(String name) {
        switch (name) {
            case "wall":
                return wall;
            case "coins":
                return coins;
            case "teleports":
                return teleports;
            case "thorn":
                return thorns;
            default:
                return new ArrayList<>();
        }
    }*/
}
