package utils;

import model.entities.Coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Parser {
    Character[][] parseMap(String pathToFile) throws IOException;
    HashMap<String,ArrayList> parseMapToItemsLevel0(String pathToFile) throws IOException;
    HashMap<String,ArrayList> parseMapToItemsLevel1(String pathToFile) throws IOException;
}
