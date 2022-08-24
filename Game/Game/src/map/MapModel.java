package map;

import utils.Parser;
import utils.ParserText;

import java.io.IOException;

public class MapModel {

    public static final int DEFAULT_WIDTH = 37;
    public static final int DEFAULT_HEIGHT = 15;

    private Character[][] card;

    public MapModel(String pathToFileLevel0) throws IOException {
        Parser parser = new ParserText();
        this.card= parser.parseMap(pathToFileLevel0);
    }

    public Character[][] copy() {
        Character[][] mapCopy = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        for(int i = 0; i<this.card.length; i++) {
            for(int j = 0; j<this.card[0].length; j++) {
                mapCopy[i][j] = this.card[i][j];
            }
        }
        return mapCopy;
    }

    public Character[][] getCard() {
        return card;
    }

}
