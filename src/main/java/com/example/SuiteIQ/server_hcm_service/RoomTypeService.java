package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.RoomType;
import java.util.List;

public interface RoomTypeService {

    List<RoomType> getAllRoomTypes();
    RoomType createRoomType(RoomType roomType);
    RoomType getRoomTypeById(Long id);
    void deleteRoomType(Long id);
    RoomType updateRoomType(Long id, RoomType updatedRoomType);
}
