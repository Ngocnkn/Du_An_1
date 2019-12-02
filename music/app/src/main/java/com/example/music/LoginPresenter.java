package com.example.music;

public class LoginPresenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (username.isEmpty()) {
            loginView.setErrorUsername();
        } else if (password.isEmpty()) {
            loginView.setErrorPassword();
        } else if (password.equalsIgnoreCase("admin")
                && username.equalsIgnoreCase("admin")) {
            loginView.navigate();
        }

    }
}
