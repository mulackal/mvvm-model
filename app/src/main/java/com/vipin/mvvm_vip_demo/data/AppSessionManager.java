package com.vipin.mvvm_vip_demo.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.vipin.mvvm_vip_demo.data.model.local.User;


import static android.content.Context.MODE_PRIVATE;


public class AppSessionManager {

	private static AppSessionManager uniqInstance;

	public User user = null;


	public synchronized static AppSessionManager getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new AppSessionManager();
		}
		return uniqInstance;
	}


	public void saveUser(Context context) {
		SharedPreferences mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = mPrefs.edit();
		Gson gson = new Gson();
		String json = gson.toJson(user);
		prefsEditor.putString("User", json);
		prefsEditor.apply();
	}

	public void loadUser(Context context) {
		SharedPreferences mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		if (mPrefs.contains("User")) {
			Gson gson = new Gson();
			String json = mPrefs.getString("User", "");
			user = gson.fromJson(json, User.class);
		} else {
			user = new User();
		}

	}


	public void deleteSavedData(String key, Context context) {
		user = new User();
		SharedPreferences mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		mPrefs.edit().remove(key).apply();
	}
}
