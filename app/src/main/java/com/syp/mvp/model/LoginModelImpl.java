package com.syp.mvp.model;

import com.syp.mvp.bean.User;
import com.syp.mvp.view.OnLoginListener;

/**
 * Created by joy on 2017/12/8.
 */

public class LoginModelImpl implements LoginModel
{
	@Override
	public void login(
			final String username,
			final String password,
			final OnLoginListener loginListener )
	{
		
		new Thread( new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Thread.sleep( 2000 );
				}
				catch( InterruptedException e )
				{
					e.printStackTrace();
				}
				//模拟登陆
				if( "syp".equals( username ) && password.equals( "456" ) )
				{
					User user = new User();
					user.setUsername( username );
					user.setPassword( password );
					loginListener.loginSuccess( user );
				}
				else
				{
					loginListener.loginFailed();
				}
			}
		} ).start();
		
	}
}
