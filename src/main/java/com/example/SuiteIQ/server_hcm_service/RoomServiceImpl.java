package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.Room;
import com.example.SuiteIQ.server_hcm_repository.RoomRepository;
import com.example.SuiteIQ.server_hcm_service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id)
                .map(existing -> {
                    existing.setRoomNumber(updatedRoom.getRoomNumber());
                    existing.setRoomTypeId(updatedRoom.getRoomTypeId());
                    existing.setStatus(updatedRoom.getStatus());
                    existing.setPrice(updatedRoom.getPrice());
                    existing.setFeatures(updatedRoom.getFeatures());
                    return roomRepository.save(existing);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
