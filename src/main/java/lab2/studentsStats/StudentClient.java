package lab2.studentsStats;

import java.io.*;
import java.text.ParseException;


public class StudentClient {


    public static void main(String[] args) throws IOException, ParseException {

        /**
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost",8888);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         */

        System.out.println("STUDENT CONNECTED");

        Student s2 = new Student("first01");
        s2.setStudentFile();

    }

}
