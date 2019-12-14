package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity implements LoginView {
    private EditText edtusername;
    private EditText edtpassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginPresenter = new LoginPresenter(this);
        edtusername = findViewById(R.id.edtusername);
        edtpassword = findViewById(R.id.edtpassword);

    }

    @Override
    public void login() {

    }

    @Override
    public void setErrorUsername() {
        edtusername.setError("nhap username");
    }

    @Override
    public void setErrorPassword() {
        edtpassword.setError("nhap password");
    }

    @Override
    public void navigate() {
        Intent inten = new Intent(this, MainActivity.class);
        startActivity(inten);

    }

    @Override
    public void rememberPasswword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public void login(View view) {
        String usernaem = edtusername.getText().toString().trim();
        String password = edtpassword.getText().toString().trim();
        loginPresenter.login(usernaem, password);
    }

    public void dangky(View view) {
    }
}
