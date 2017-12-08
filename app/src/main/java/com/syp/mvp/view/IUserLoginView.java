package com.syp.mvp.view;

/**
 * Created by joy on 2017/12/8.
 */

public interface IUserLoginView
{
	
	String getUserName();
	
	String getPassword();
	
	void clearUserName();
	
	void clearPassword();
	
	void showLoading();
	
	void hideLoading();
	
	void loginSucceed();
	
	void loginFailedShow();
}
