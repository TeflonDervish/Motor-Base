package service;


public class AuthService {

    private static final AuthService authService = new AuthService();

    private AuthService() {}

    public AuthService getLoginService() {
        return authService;
    }

    public boolean checkUser(String login, String password) {

        return login.equals("admin") && password.equals("admin");

    }


}
