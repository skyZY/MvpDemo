package com.syp.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.syp.mvp.present.UserLoginPresent;
import com.syp.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView
{
	private EditText mEdtUserName;
	private EditText mEdtPassword;
	private Button mBtnLogin;
	private Button mBtnCancel;
	private ProgressBar mPb;
	
	public UserLoginPresent mUserLoginPresent;
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		mUserLoginPresent = new UserLoginPresent( this );
		initView();
	}
	
	void initView()
	{
		mEdtUserName = findViewById( R.id.edit_username );
		mEdtPassword = findViewById( R.id.edit_password );
		mBtnLogin = findViewById( R.id.btn_login );
		mBtnCancel = findViewById( R.id.btn_cancel );
		mPb = findViewById( R.id.pb );
		mBtnLogin.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View view )
			{
				mUserLoginPresent.login();
			}
		} );
		mBtnCancel.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View view )
			{
				mUserLoginPresent.clear();
			}
		} );
		
	}
	
	@Override
	public String getUserName()
	{
		String username = mEdtUserName.getText().toString();
		return TextUtils.isEmpty( username ) ? "" : username;
	}
	
	@Override
	public String getPassword()
	{
		String password = mEdtPassword.getText().toString();
		return TextUtils.isEmpty( password ) ? "" : password;
	}
	
	@Override
	public void clearUserName()
	{
		mEdtUserName.setText( "" );
	}
	
	@Override
	public void clearPassword()
	{
		mEdtPassword.setText( "" );
	}
	
	@Override
	public void showLoading()
	{
		mPb.setVisibility( View.VISIBLE );
	}
	
	@Override
	public void hideLoading()
	{
		mPb.setVisibility( View.GONE );
	}
	
	@Override
	public void loginSucceed()
	{
		Toast.makeText( MainActivity.this, "login success", Toast.LENGTH_SHORT ).show();
	}
	
	@Override
	public void loginFailedShow()
	{
		Toast.makeText( MainActivity.this, "login fail", Toast.LENGTH_SHORT ).show();
	}
}
