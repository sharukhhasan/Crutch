package com.sharukhhasan.studycrutch;

import android.app.Application;

import com.sharukhhasan.studycrutch.models.Course;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sharukhhasan on 5/20/16.
 */
public class AppController extends Application{
    public static final String FIREBASE_URL = "https://studycrutch.firebaseio.com/";
    public static ArrayList<String> engrDepts = getEngrDepts();
    public static Map<String, ArrayList<String>> engrCourseMap = getEngrCourseMap();

    public static ArrayList<Course> enrolledCourses;

    @Override
    public void onCreate()
    {
        super.onCreate();

        try {
            getDeptList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getDeptList() throws IOException
    {
        ArrayList<String> returnDeptList = new ArrayList<>();
        engrDepts = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("departments.csv"));
        String lineInput = null;

        while((lineInput = bufferedReader.readLine()) != null)
        {
            Scanner sc = new Scanner(lineInput);
            sc.useDelimiter(",");
            returnDeptList.add(sc.next());
            engrDepts.add(sc.next());
        }

        for(String dept : returnDeptList)
        {
            getCourseList(dept);
        }

        return returnDeptList;
    }

    public static void getCourseList(String dept) throws IOException
    {
        engrCourseMap.put(dept, new ArrayList<String>());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(dept+".csv"));
        String lineInput = null;

        while((lineInput = bufferedReader.readLine()) != null)
        {
            Scanner sc = new Scanner(lineInput);
            sc.useDelimiter(",");
            engrCourseMap.get(dept).add(sc.next());
        }
    }

    public static Map<String, ArrayList<String>> getEngrCourseMap()
    {
        return engrCourseMap;
    }

    public static ArrayList<String> getEngrDepts()
    {
        return engrDepts;
    }

    public static void addCourse(Course course)
    {
        enrolledCourses.add(course);
    }
}
