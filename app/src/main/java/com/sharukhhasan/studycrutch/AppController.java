package com.sharukhhasan.studycrutch;

import android.app.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sharukhhasan on 5/20/16.
 */
public class AppController extends Application{
    private static final String numberPath = "coursesOrganized.csv";
    private static final String namePath = "courseNames.csv";
    private static Map<String, ArrayList<String>> courseNumberMap;
    private static Map<String, ArrayList<String>> courseNameMap;
    public static Map<String, ArrayList<String>> courseMap;
    public static ArrayList<String> courseList;
    private static boolean num = false;
    private static final String[] csvEngrFiles = {"BME.csv", "CBE.csv", "CEE.csv", "ECE.csv", "ENGR.csv", "IE.csv", "ME.csv"};
    public static Map<String, ArrayList<String>> engrCourseMap;
    public static ArrayList<String> engrDepts;

    @Override
    public void onCreate()
    {
        super.onCreate();

        try {
            createEngrCourseMao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createEngrCourseMao() throws IOException
    {
        engrCourseMap = new HashMap<>();
        engrDepts = new ArrayList<>();
        boolean firstInput = true;

        for(String engrFile : csvEngrFiles)
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(engrFile));
            String lineInput = null;
            firstInput = true;
            String dept = null;

            while((lineInput = bufferedReader.readLine()) != null)
            {
                Scanner sc = new Scanner(lineInput);
                sc.useDelimiter(",");

                if(firstInput)
                {
                    dept = sc.next();
                    engrDepts.add(dept);
                    engrCourseMap.put(dept, new ArrayList<String>());
                    firstInput = false;
                }
                else
                {
                    engrCourseMap.get(dept).add(sc.next() + " " + sc.next());
                }
            }
        }

    }

    public ArrayList<String> getEngrDepts()
    {
        return engrDepts;
    }

    public Map<String, ArrayList<String>> getCourses()
    {
        return engrCourseMap;
    }
}
