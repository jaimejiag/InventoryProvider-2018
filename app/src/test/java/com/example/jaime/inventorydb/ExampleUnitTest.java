package com.example.jaime.inventorydb;

import com.example.jaime.inventorydb.data.db.model.User;
import com.example.jaime.inventorydb.data.db.repository.UserRepository;
import com.example.jaime.inventorydb.ui.utils.CommonUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private ArrayList<User> users;

    @Mock
    private UserRepository userRepository;


    //Before se ejecuta antes que cualquier método.
    @Before
    public void initialize() {
        users = new ArrayList<>();
        userRepository = mock(UserRepository.class);

        users.add(new User(1, "jaime", "Jaime1", "Jaime",
                "jaime@gmail.com", true, true));

        users.add(new User(2, "julia", "julia", "Julia",
                "julia@gmail.com", false, false));

        users.add(new User(3, "paco", "nopaco", "Paco",
                "nopaco@gmail.com", false, true));
    }


    @Test
    public void testAssertions() {
        User user = new User(1, "jaime", "jaime", "Jaime",
                "jaime@gmail.com", true, true);
        User user2 = null;
        User user3 = user;

        //Comprobar si dos objetos son iguales.
        assertEquals(user, users.get(0));

        //Un objeto null
        assertNull(user2);

        //Un objeto no es null
        assertNotNull(user);

        //Dos objetos apuntan a la misma referencia.
        assertSame(user, user3);
    }


    //1. El ususario introduce un usuario/email.


    //2. EL usuario introduce una contraseña.


    //3. El ususario existe en la base de datos.
    @Test
    public void isUserExists_isCorrect() {
        //Cuando se llame al método isUserExists, devuelve un valor predeterminado.
        when(userRepository.isUserExits(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExits(users.get(0)));
    }


    @Test
    public void getUsers_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }


    //4. Comprobar la constraseña sea correcta.
    @Test
    public void password_isCorrect() {
        assertTrue(CommonUtils.isPasswordValid(users.get(0).getPassword()));
    }



    @Test
    public void login_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void signUp_isCorrect() throws Exception {
        //5. El ususario introduce un usuario/email.

        //6. EL usuario introduce una contraseña.

        //7. El usuario introduce un email.

        //8. La contraseña al menos 6 carácteres.

        //9. El email no existe en la base de datos.

        //10. El ususario no existe en la base de datos.

        //11. Doble comprobación de la contraseña.
    }
}