import java.net.SocketTimeoutException;

public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
check("Polina", "123", "123");
        check("Polina", "1231", "123");
        check("Polina&&", "123", "123");
        check("Polina", "1232132108425275927676456038638099", "123");

    }

    private static void check(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка в логине " + e.getMessage() );
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка в пароле " + e.getMessage());
        }


    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Login содержит в себе только латинские буквы, " +
                    "цифры и знак подчеркивания.");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Login не может быть более 20 символов");
        }
    }

        private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
            if (!password.matches(VALIDATE_PATTERN)) {
                throw new WrongPasswordException("Пароль содержит в себе только латинские буквы, " +
                        "цифры и знак подчеркивания.");
            }
            if (password.length() > 20) {
                throw new WrongPasswordException("Пароль не может быть более 20 символов");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }

        }
    }