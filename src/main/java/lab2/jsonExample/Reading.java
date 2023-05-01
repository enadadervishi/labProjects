package lab2.jsonExample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

public class Reading {

    JSONObject person;

    ArrayList arr;
    String n,s;

    public Reading() throws IOException, ParseException {
        this.person = (JSONObject) new JSONParser().parse(new FileReader("src/main/resources/outputJSON.json"));

        this.s = new String();
        this.n = new String();
    }

    public void readingJSON(){

        n = (String) person.get("name");
        System.out.println("Name " +n);
        s = (String) person.get("surname");
        System.out.println("Surname " +s);
        arr = (ArrayList) person.get("children");
        Iterator i = arr.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }


    }




}
