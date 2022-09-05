package utils;

import model.entities.Coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Parser {
    Character[][] parseMapTerrainToArray(String pathToFile) throws IOException;
    HashMap<String,ArrayList> parseMapToTerrain(String pathToFile) throws IOException;
    HashMap<String,ArrayList> parseMapToItems(String pathToFile) throws IOException;
}
