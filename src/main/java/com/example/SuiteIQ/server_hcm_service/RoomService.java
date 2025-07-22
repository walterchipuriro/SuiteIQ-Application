package com.example.SuiteIQ.server_hcm_service;
import com.example.SuiteIQ.server_hcm_domain.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room createRoom(Room room);
    List<Room> getAllRooms();
    Optional<Room> getRoomById(Long id);
    Room updateRoom(Long id, Room updatedRoom);
    boolean deleteRoom(Long id);
}

