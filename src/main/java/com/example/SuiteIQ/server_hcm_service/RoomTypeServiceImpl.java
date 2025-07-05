package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.RoomType;
import com.example.SuiteIQ.server_hcm_repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType createRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType getRoomTypeById(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomType updateRoomType(Long id, RoomType updatedRoomType) {
        return roomTypeRepository.findById(id).map(existing -> {
            existing.setName(updatedRoomType.getName());
            existing.setDescription(updatedRoomType.getDescription());
            existing.setMaximumOccupancy(updatedRoomType.getMaximumOccupancy());
            existing.setPricePerNight(updatedRoomType.getPricePerNight());
            return roomTypeRepository.save(existing);
        }).orElse(null); // or throw custom exception
    }
}
