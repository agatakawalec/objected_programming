/**
 *
 * @author Agata
 * @version 1.0
 * @param _login login jaki dana instancja klasy będiz eprzechowywać
 * @param _password hasło jakie dana instancja klasy będiz eprzechowywać
 */

package zad4;
public class Login {
    private String login;
    private String password;
    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }
    public boolean check(String _login, String _password){
        if(_login.equals(login) && _password.equals(password)) return true;
        else return false;
    }
}

