package com.sharukhhasan.studycrutch.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sharukh on 1/27/16.
 */
public class VolleySingleton
{
    private static VolleySingleton vInstance = null;
    private static Context context;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private VolleySingleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();
        imageLoader = new ImageLoader(this.requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(20);

            public void putBitmap(String url, Bitmap bitmap)
            {
                cache.put(url, bitmap);
            }

            public Bitmap getBitmap(String url)
            {
                return cache.get(url);
            }
        });
    }

    public static VolleySingleton getInstance(Context contxt)
    {
        context = contxt;
        if(vInstance == null)
        {
            vInstance = new VolleySingleton(context);
        }
        return vInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader()
    {
        return this.imageLoader;
    }
}
