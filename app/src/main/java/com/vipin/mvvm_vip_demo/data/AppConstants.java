package com.vipin.mvvm_vip_demo.data;





public class AppConstants {


    private static AppConstants appConstantsInstance;


	public synchronized static final AppConstants getInstance() {
		if (appConstantsInstance == null) {
			appConstantsInstance = new AppConstants();
		}
		return appConstantsInstance;
	}
	// Shared preference name is same as Application package name
	public String SHARED_PREFENCE_NAME = "mySession";


	// Total number of items without commission menu
	public  final int DATA = 10;


}
