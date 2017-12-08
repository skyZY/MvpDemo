package com.syp.mvp.view;

import com.syp.mvp.bean.User;

/**
 * Created by joy on 2017/12/8.
 */

public interface OnLoginListener
{
	void loginSuccess( User user );
	
	void loginFailed();
}
