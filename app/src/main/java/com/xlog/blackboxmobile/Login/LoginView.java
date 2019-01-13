package com.xlog.blackboxmobile.Login;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setErrorMessage();

    void navigateToDashboard();

    void showError(String Message, String MessageBody);

}