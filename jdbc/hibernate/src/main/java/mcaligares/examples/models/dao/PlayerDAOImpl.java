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

package mcaligares.examples.models.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mcaligares.examples.models.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PlayerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(Player player) {
        getCurrentSession().save(player);
    }

    @Override
    public void update(Player player) {
        getCurrentSession().update(player);
    }

    @Override
    public void delete(Player player) {
        getCurrentSession().delete(player);
    }

    @Override
    public Player getById(Long id) {
        return (Player) getCurrentSession().get(Player.class, id);
    }

    @Override
    public List<Player> findAll() {
        return getCurrentSession().createCriteria(Player.class).list();
    }

    @Override
    public List<Player> findByUsername(String username) {
        return getCurrentSession().createCriteria(Player.class)
                .add(Restrictions.ilike("username", username)).list();
    }

}
