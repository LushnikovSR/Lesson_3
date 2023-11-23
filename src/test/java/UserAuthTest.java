import org.Task_1.User;
import org.Task_1.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthTest {
/*
3.6 Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
введенные логин и пароль корректны, иначе false. Протестируйте все методы
 */
    private User user_1;

    @BeforeEach
    public void setup(){
        user_1 = new User("John", "haha12345", false);
    }

    @Test
    public void userEnterFalseName(){
        assertFalse(user_1.authenticate("Sam", "haha12345"));
    }

    @Test
    public void userEnterFalsePassword(){
        assertFalse(user_1.authenticate("John", "9haha12349"));
    }

    @Test
    public void userEnterCorrectData(){
        assertTrue(user_1.authenticate("John", "haha12345"));
    }

/*
3.7 Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
addUser, который добавляет пользователя в систему, если он прошел аутентификацию. Покройте тестами новую
функциональность
*/
    @Test
    public void userAuthenticatedAndAddedToDatabase(){
        user_1.authenticate("John", "haha12345");
        UserRepository.addUser(user_1);
        assertThat(user_1).isIn(UserRepository.data);
    }

    @Test
    public void userNotAuthenticatedAndNotAddedToDatabase(){
        user_1.authenticate("Matt", "haha12345");
        UserRepository.addUser(user_1);
        assertThat(user_1).isNotIn(UserRepository.data);
    }

    @Test
    public void checkUnlogAllUsersExceptAdministrators(){
        user_1 = new User("John", "haha12345", false);
        User user_2 = new User("Jack", "sparrow666", true);

        user_1.authenticate("John", "haha12345");
        user_2.authenticate("Jack", "sparrow666");

        UserRepository.addUser(user_1);
        UserRepository.addUser(user_2);

        UserRepository.unlogAllUsersExceptAdministrators();

        assertFalse(UserRepository.data.get(UserRepository.data.size() - 2).isAuthenticate);
        assertTrue(UserRepository.data.get(UserRepository.data.size() - 1).isAuthenticate);
    }
}
