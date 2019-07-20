package pl.conectis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSystemTest {


    LoginSystem loginSystem = new LoginSystem();


    @ParameterizedTest
    @CsvFileSource(resources = "/logAndpass.csv")
    void addCoupleTest(String log,String pas,boolean result){
        loginSystem.registerProces("Artur","Haslo12123");
        assertEquals(result,loginSystem.registerProces(log,pas));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/baseOfUser.csv")
    void logInTest(String login,String password,boolean result){
        loginSystem.registerProces("Artur","Haslo12123");
        loginSystem.registerProces("Kuba","Kupa121212");
        loginSystem.registerProces("Dawid","cosTam3434");
        loginSystem.registerProces("Robert","Haslo12123");

        assertEquals(result,loginSystem.loginProces(login,password));

    }




}
