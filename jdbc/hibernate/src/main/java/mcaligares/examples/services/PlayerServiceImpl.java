/*
 * Copyright 2015 Miguel Augusto Caligares <mcaligares@gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mcaligares.examples.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import mcaligares.examples.models.Player;
import mcaligares.examples.models.dao.PlayerDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerDAO playerDAO;

    @Autowired
    public PlayerServiceImpl(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void insert(Player player) {
        assertNotNull(player);
        playerDAO.insert(player);
    }

    public void update(Player player) {
        assertNotNull(player);
        playerDAO.update(player);
    }

    public void delete(Player player) {
        assertNotNull(player);
        playerDAO.delete(player);
    }

    @Transactional(readOnly=true)
    public Player getById(Long id) {
        return id != null ? playerDAO.getById(id) : null;
    }

    @Transactional(readOnly=true)
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Transactional(readOnly=true)
    public List<Player> findByUsername(String username) {
        return username != null ? playerDAO.findByUsername(username) : null;
    }

}
