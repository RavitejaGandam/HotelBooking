package com.ravi.hotelbooking.repository;

import com.ravi.hotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
