package com.xlog.blackboxmobile.Login;
/**
 * Created by Jay on 12/03/2018.
 */
public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }


    public void validateCredentials(String username, String password, Boolean type) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password,type,this);
    }



    @Override
    public void onErrorMessage() {
        if (loginView != null) {
            loginView.setErrorMessage();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToDashboard();
        }
    }

    @Override
    public void errorLogin(String message, String messageBody) {
        if (loginView != null) {
            loginView.showError(message, messageBody);
            loginView.hideProgress();
        }
    }


}
