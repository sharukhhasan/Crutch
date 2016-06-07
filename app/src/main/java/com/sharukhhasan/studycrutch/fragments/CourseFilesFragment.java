package com.sharukhhasan.studycrutch.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;
import com.sharukhhasan.studycrutch.AppController;
import com.sharukhhasan.studycrutch.R;

/**
 * Created by sharukhhasan on 6/7/16.
 */
public class CourseFilesFragment extends Fragment {
    private DropboxAPI<AndroidAuthSession> mDBApi;
    Button uploadFileBtn;
    ListView filesList;

    public static CourseFilesFragment newInstance()
    {
        CourseFilesFragment courseFilesFragment = new CourseFilesFragment();
        return courseFilesFragment;
    }

    public CourseFilesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_coursefiles, container, false);

        uploadFileBtn = (Button) rootView.findViewById(R.id.uploadBtn);
        uploadFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

        filesList = (ListView) rootView.findViewById(R.id.files_list);

        AppKeyPair appKeys = new AppKeyPair(AppController.DROPBOX_APP_KEY, AppController.DROPBOX_APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);

        mDBApi.getSession().startOAuth2Authentication(getContext());


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }
}
