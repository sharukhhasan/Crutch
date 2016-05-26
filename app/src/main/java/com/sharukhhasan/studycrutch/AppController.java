package com.sharukhhasan.studycrutch;

import android.app.Application;
import android.os.Bundle;

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
    public static final String FIREBASE_URL = "https://studycrutch.firebaseio.com/";
    public static final Map<String, ArrayList<String>> engrCourseMap = new HashMap<>();
    public static final ArrayList<String> engrDepts = new ArrayList<>();

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

    public void getDeptList() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("departments.csv"));
        String lineInput = null;

        while((lineInput = bufferedReader.readLine()) != null)
        {
            Scanner sc = new Scanner(lineInput);
            sc.useDelimiter(",");
            engrDepts.add(sc.next());
        }

        for(String dept : engrDepts)
        {
            getCourseList(dept);
        }
    }

    public void getCourseList(String dept) throws IOException
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

    public Map<String, ArrayList<String>> getEngrCourseMap()
    {
        return engrCourseMap;
    }

    public ArrayList<String> getEngrDepts()
    {
        return engrDepts;
    }
}
