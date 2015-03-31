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

import mcaligares.examples.models.Player;

public interface PlayerDAO {

    void insert(Player player);

    void update(Player player);

    void delete(Player player);

    Player getById(Long id);

    List<Player> findAll();

    List<Player> findByUsername(String username);

}
