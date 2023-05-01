package lab2.jsonExample;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        //Writing w = new Writing();
        //w.writingJSON();

        Reading r = new Reading();
        r.readingJSON();


    }

}
