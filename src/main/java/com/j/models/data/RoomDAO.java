package com.j.models.data;

import com.j.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by J on 5/16/2017.
 */
@Repository
public interface RoomDAO extends CrudRepository<Room, Long> {
    Room findByNumber(String number);
}
