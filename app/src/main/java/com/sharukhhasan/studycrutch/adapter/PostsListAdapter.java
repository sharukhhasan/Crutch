package com.sharukhhasan.studycrutch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.sharukhhasan.studycrutch.R;
import com.sharukhhasan.studycrutch.models.WallPost;
import com.sharukhhasan.studycrutch.utils.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharukhhasan on 6/7/16.
 */
public class PostsListAdapter extends BaseAdapter {
    private List<WallPost> wallPostsList = new ArrayList<>();
    private Context context;

    public PostsListAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return wallPostsList.size();
    }

    @Override
    public WallPost getItem(int position)
    {
        return wallPostsList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.wallpost_row, parent, false);
        }

        TextView postSubjectTextView = (TextView) convertView.findViewById(R.id.post_subject);
        TextView userNameTextView = (TextView) convertView.findViewById(R.id.user_name);

        WallPost wallPost = wallPostsList.get(position);
        postSubjectTextView.setText(wallPost.getTitle());
        userNameTextView.setText(wallPost.getUserPosted().getName());

        ImageLoader imageLoader = VolleySingleton.getInstance(context).getImageLoader();
        NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.contact_image);
        imageView.setImageUrl(wallPost.getSmallImageURL(), imageLoader);

        return convertView;
    }

    public List<WallPost> getWallPostsList()
    {
        return wallPostsList;
    }

    public void setWallPostsList(List<WallPost> wallPostsList)
    {
        this.wallPostsList = wallPostsList;
    }
}
