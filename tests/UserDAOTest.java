
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codecollab.dao.UserDAO;
import com.codecollab.models.User;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    public void setup() {
        userDAO = new UserDAO();
    }

    @Test
    public void testSaveUser() {
        User user = new User("Jane", "jane@example.com", "securePass");
        boolean result = userDAO.save(user);

        assertTrue(result);
    }
}
