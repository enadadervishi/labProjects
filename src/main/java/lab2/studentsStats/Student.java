package lab2.studentsStats;

import org.json.simple.JSONObject;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * How to create a json file with more than one object
 * like JSONObject file in resources
 */
public class Student {

    String idNumber;
    String name;
    String surname;
    String residence;
    LocalDate date_of_birth;
    int year;

    BufferedReader inFromUser;

    JSONObject studentDetails;
    FileWriter studentFile;

    //ArrayList<JSONObject> arr;

    public Student(String id) throws IOException {

        this.inFromUser = new BufferedReader(new InputStreamReader(System.in));
        this.studentDetails = new JSONObject();
        this.studentFile = new FileWriter("src/main/resources/StudentFileDetails.json");


        //this.arr = new ArrayList<>();


        this.idNumber = id;

        System.out.println("Enter name: ");
        this.name = inFromUser.readLine();

        System.out.println("Enter surname: ");
        this.surname = inFromUser.readLine();

        System.out.println("Enter date of birth [YYYY-MM-DD]: ");
        this.date_of_birth = LocalDate.parse(inFromUser.readLine());

        this.year = LocalDate.parse(inFromUser.readLine()).getYear();

        System.out.println("Enter place of residence: ");
        this.residence = inFromUser.readLine();

    }

    public void setStudentFile() throws IOException {


        this.studentDetails.put("name", this.name);
        this.studentDetails.put("surname", this.surname);
        this.studentDetails.put("yearOfBirth", this.year);
        this.studentDetails.put("residence", this.residence);


        this.studentFile.write(this.studentDetails.toJSONString());
        this.studentFile.close();
    }

}
