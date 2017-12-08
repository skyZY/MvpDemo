package com.syp.mvp.present;

import android.os.Handler;

import com.syp.mvp.bean.User;
import com.syp.mvp.model.LoginModelImpl;
import com.syp.mvp.view.IUserLoginView;
import com.syp.mvp.view.OnLoginListener;

/**
 * Created by joy on 2017/12/8.
 */

public class UserLoginPresent
{
	
	private LoginModelImpl mLoginModelImpl;
	private IUserLoginView mIuserLoginView;
	
	private Handler mHandler = new Handler();
	
	public UserLoginPresent( IUserLoginView iUserLoginView )
	{
		mLoginModelImpl = new LoginModelImpl();
		this.mIuserLoginView = iUserLoginView;
	}
	
	public void login()
	{
		mIuserLoginView.showLoading();
		mLoginModelImpl.login( mIuserLoginView.getUserName(), mIuserLoginView.getPassword(), new OnLoginListener()
		{
			@Override
			public void loginSuccess( User user )
			{
				mHandler.post( new Runnable()
				{
					@Override
					public void run()
					{
						mIuserLoginView.loginSucceed();
						mIuserLoginView.hideLoading();
					}
				} );
			}
			
			@Override
			public void loginFailed()
			{
				mHandler.post( new Runnable()
				{
					@Override
					public void run()
					{
						mIuserLoginView.loginFailedShow();
						mIuserLoginView.hideLoading();
					}
				} );
				
			}
		} );
	}
	
	public void clear()
	{
		mIuserLoginView.clearUserName();
		mIuserLoginView.clearPassword();
	}
	
}
