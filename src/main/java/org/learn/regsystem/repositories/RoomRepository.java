package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}