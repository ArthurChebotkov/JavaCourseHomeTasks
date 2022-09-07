package scene;

import map.MapModel;
import models.Position;
import models.actors.Actor;
import models.actors.KillerPlayer;
import models.actors.Player;
import models.entities.*;
import utils.Parser;
import utils.ParserText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Scene {
    public final int DEFAULT_START_POSITION_X = 5;
    public final int DEFAULT_START_POSITION_Y = 10;
    private MapModel mapModel;
    private HashMap<String, Actor> actors;
    private HashMap<String, ArrayList> terrain;
    private HashMap<String, ArrayList> items;


    public Scene(String pathToFileLevelTerrain, String pathToFileLevelItems) throws IOException {
        Parser parser = new ParserText();
        this.mapModel = new MapModel(pathToFileLevelTerrain, parser);

        this.terrain = new HashMap<String, ArrayList>();
        terrain = parser.parseMapToTerrain(pathToFileLevelTerrain);

        this.items = new HashMap<String, ArrayList>();
        items = parser.parseMapToItems(pathToFileLevelItems);

        this.actors = new HashMap<String, Actor>();
        actors.put("player", new Player(new Position(DEFAULT_START_POSITION_X, DEFAULT_START_POSITION_Y)));
        actors.put("killerPlayer", new KillerPlayer(new Position(DEFAULT_START_POSITION_X + 2, DEFAULT_START_POSITION_Y - 2)));

    }

    public MapModel getMapModel() {
        return mapModel;
    }
    public HashMap<String, Actor> getActors() {
        return actors;
    }
    public HashMap<String, ArrayList> getTerrain() {
        return terrain;
    }

    public Actor getActorsByName(String name) {
        switch (name) {
            case "player":
                return actors.get("player");
            case "killerPlayer":
                return actors.get("killerPlayer");
            default:
                break;
        }
        return null;
    }

    public ArrayList<Entity> getTerrainByName(String name) {
        switch (name) {
            case "wall":
                return terrain.get("wall");
            case "listFloor":
                return terrain.get("listFloor");
            default:
                break;
        }
        return null;
    }


    public ArrayList<Entity> getItemsByName(String name) {
        switch (name) {
            case "coins":
                return items.get("coins");
            case "teleports":
                return items.get("teleports");
            case "thorns":
                return items.get("thorns");
            case "firstAid":
                return items.get("firstAid");
            default:
                break;
        }
        return null;
    }

    public ArrayList<ArrayList> getItemsArrayList() {
        ArrayList<ArrayList> itemArrayList = new ArrayList<>();
        items.forEach((k, v) -> {
            itemArrayList.add(v);
        });
        return itemArrayList;
    }

    public HashMap<String, ArrayList> getItems() {
        return items;
    }
}
