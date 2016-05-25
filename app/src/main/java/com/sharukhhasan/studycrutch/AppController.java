package com.sharukhhasan.studycrutch;

import android.app.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
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

        for(String file : csvEngrFiles)
        {
            try {
                buildCourseList(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public static void buildCourseList(String path) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String lineInput = null;

        while((lineInput = bufferedReader.readLine()) != null)
        {
            Scanner sc = new Scanner(lineInput);
            sc.useDelimiter(",");

            while(sc.hasNext())
            {
                System.out.println(sc.next());
            }
        }
    }

    public Map<String, ArrayList<String>> getCourses(String path) throws IOException {
        courseMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String inputLine;

        while((inputLine = reader.readLine()) != null)
        {
            Scanner lineScanner = new Scanner(inputLine);
            lineScanner.useDelimiter(",");
            String prev_dept = null;

            while(lineScanner.hasNext())
            {
                String temp = lineScanner.next();
                if(!num)
                {
                    prev_dept = temp;
                    courseMap.put(temp, new ArrayList<String>());
                    num = true;
                }
                else
                {
                    courseMap.get(prev_dept).add(temp);
                }
            }
            num = false;
        }

        return courseMap;
    }

    public void syncData(Map<String, ArrayList<String>> numberMap, Map<String, ArrayList<String>> nameMap)
    {
        courseMap = new HashMap<>();
        courseList = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry : numberMap.entrySet())
        {
            String dept = entry.getKey();
            ArrayList<String> numbers = entry.getValue();
            ArrayList<String> names = nameMap.get(dept);
            courseMap.put(dept, new ArrayList<String>());

            for(int i = 0; i < numbers.size(); i++)
            {
                String concatCourse = dept + numbers.get(i) + " " + names.get(i);
                courseMap.get(dept).add(concatCourse);
                courseList.add(concatCourse);
            }
        }
    }

    public Map<String, ArrayList<String>> getCourses()
    {
        return courseMap;
    }
}
