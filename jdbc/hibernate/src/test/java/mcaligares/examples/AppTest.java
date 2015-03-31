package mcaligares.examples;

import static org.junit.Assert.*;

import java.util.List;

import mcaligares.examples.models.Player;
import mcaligares.examples.services.PlayerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class AppTest {

    @Autowired
    PlayerService service;

    @Test
    public void insert() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());
    }

    @Test
    public void update() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());

        Long id = player.getId();
        player.setUsername("miguel");
        service.update(player);

        player = service.getById(id);
        assertNotNull(player);
        assertEquals("miguel", player.getUsername());
    }

    @Test
    public void delete() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());

        Long id = player.getId();
        service.delete(player);

        player = service.getById(id);
        assertNull(player);
    }

    @Test
    public void getById() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());

        Long id = player.getId();

        Player player2 = service.getById(id);
        assertNotNull(player2);
        assertEquals(player.getId(), player2.getId());
    }

    @Test
    public void findAll() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());

        List<Player> players = service.findAll();
        assertNotNull(players);
        assertFalse(players.isEmpty());
    }

    @Test
    public void findByUsername() {
        Player player = new Player("mcaligares");
        service.insert(player);
        assertNotNull(player.getId());

        List<Player> players = service.findByUsername("mcaligares");
        assertNotNull(players);
        assertFalse(players.isEmpty());
    }

}
