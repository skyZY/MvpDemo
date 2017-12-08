package com.syp.mvp.model;

import com.syp.mvp.view.OnLoginListener;

/**
 * Created by joy on 2017/12/8.
 */

public interface LoginModel
{
	void login(
			String username,
			String password,
			OnLoginListener loginListener );
}
