
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.codecollab.dao.UserDAO;
import com.codecollab.services.UserService;
import com.codecollab.models.User;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDAO userDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User("John", "john@example.com", "password123");
        when(userDAO.save(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(userDAO, times(1)).save(user);
    }
}
