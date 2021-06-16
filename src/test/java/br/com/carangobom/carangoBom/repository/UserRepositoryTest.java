package br.com.carangobom.carangoBom.repository;

import br.com.carangobom.carangoBom.model.Profile;
import br.com.carangobom.carangoBom.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void shouldReturnAllusers(){
        String userName = "teste";
        String email = userName.concat("@teste.com");
        User userCreated = createUser(userName);

        em.persist(userCreated);

        Optional<User> userResponse = userRepository.findByEmail(email);

        Assert.assertTrue(userResponse.isPresent());
        User user = userResponse.get();
        Assert.assertNotNull(user);
        Assert.assertEquals(email, user.getUsername());
    }

    @Test
    public void shouldNotReturnUser(){
        Optional<User> userResponse = userRepository.findById(1L);

        Assert.assertFalse(userResponse.isPresent());
    }

    private User createUser(String name){
        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        User user = new User();

        profile.setName(name);
        profiles.add(profile);

        user.setEmail(name.concat("@teste.com"));
        user.setProfiles(profiles);
        user.setPassword("12345");

        return user;
    }
}
