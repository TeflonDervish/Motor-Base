package service;


public class LoginService {

    private static final LoginService loginService = new LoginService();

    private LoginService() {}

    public LoginService getLoginService() {
        return loginService;
    }

    public boolean checkUser(String login, String password) {
        return true;
    }


}
