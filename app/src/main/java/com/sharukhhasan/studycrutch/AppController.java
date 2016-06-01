package com.sharukhhasan.studycrutch;

import android.app.Application;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
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

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "BZiwEDSzT5K367WqCmD1WO6RD";
    private static final String TWITTER_SECRET = "oC2YvyXcIukWZMSYTolmNixjJwacjJpxUFvKnkeSvv7AM0yQ7b";

    public static final String FIREBASE_URL = "https://studycrutch.firebaseio.com/";
    public static final Map<String, ArrayList<String>> engrCourseMap = new HashMap<>();
    public static final ArrayList<String> engrDepts = new ArrayList<>();

    @Override
    public void onCreate()
    {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

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
