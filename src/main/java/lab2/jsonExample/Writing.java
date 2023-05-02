package lab2.jsonExample;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writing {

    JSONObject person = new JSONObject();
    FileWriter fileWriter;

    public Writing() throws IOException {
        this.person.put(" name ", " Tonio ");
        this.person.put(" surname ", " Cartonio ");

        this.person.put(" children ", List.of(" Lupo Lucio ", " Orco Rubio ", " Strega Salamadra "));

        fileWriter = new FileWriter("src/main/resources/lab2/outputJSON.json");
    }

    public void writingJSON() throws IOException {
        fileWriter.write(this.person.toJSONString());
        fileWriter.close();

        System.out.println(this.person);
    }


}
