package com.wm.remusic.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.wm.remusic.MainApplication;
import com.wm.remusic.activity.BaseActivity;
import com.wm.remusic.activity.MusicStateListener;
import com.wm.remusic.service.ForceUpdateChecker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wm on 2016/3/17.
 */
public class BaseFragment extends Fragment implements MusicStateListener {

    public Activity mContext;
    private static final String TAG = BaseFragment.class.getSimpleName();

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.mContext = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
//
//        // set in-app defaults
        Map<String, Object> remoteConfigDefaults = new HashMap();
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_REQUIRED, false);
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_CURRENT_VERSION, "1.0.3");
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_URL,
                "https://play.google.com/store/apps/details?id=com.wm.fuyin");

        firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
        firebaseRemoteConfig.fetch(43200) // fetch every 12 hours
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "remote config is fetched.");
                            firebaseRemoteConfig.activateFetched();
                        }
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((BaseActivity) getActivity()).setMusicStateListenerListener(this);
        reloadAdapter();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((BaseActivity) getActivity()).removeMusicStateListenerListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void updateTrackInfo() {

    }

    @Override
    public void updateTime() {

    }

    @Override
    public void changeTheme() {

    }

    @Override
    public void reloadAdapter() {

    }


}
