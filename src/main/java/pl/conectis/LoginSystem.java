package pl.conectis;

import java.util.HashMap;
import java.util.Map;

public class LoginSystem {

    private Map<String,String> loginIHaslo;


    public LoginSystem() {
        this.loginIHaslo = new HashMap<String, String>();
    }


    public boolean registerProces(String login, String password){

        if (!login.equals(password) && !login.equals("") && !password.equals("") &&password.length()>=8&&password.matches(".*\\d.*")&&password.matches(".*[A-Z].*" )&& !loginIHaslo.containsKey(login)){
        loginIHaslo.put(login,password);
        return true;
        }

        return false;

    }

    public Map<String, String> getLoginIHaslo() {
        return loginIHaslo;
    }

    public void setLoginIHaslo(Map<String, String> loginIHaslo) {
        this.loginIHaslo = loginIHaslo;
    }

    public boolean loginProces(String login, String password){
        if (loginIHaslo.containsKey(login)){
            if (loginIHaslo.get(login).equals(password)){
                System.out.println("zalogowany");
                return true;
            }else System.out.println("Zle haslo");

        }else System.out.println("Nie ma takiego loginu");


        return false;
    }

}
