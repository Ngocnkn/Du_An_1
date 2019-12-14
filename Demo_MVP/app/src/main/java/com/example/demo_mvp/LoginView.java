package com.example.demo_mvp;

public interface LoginView {
    void login();

    void setErrorUsername();

    void setErrorPassword();

    void navigate();

    void rememberPasswword();

    void showLoading();

    void hideLoading();

}
