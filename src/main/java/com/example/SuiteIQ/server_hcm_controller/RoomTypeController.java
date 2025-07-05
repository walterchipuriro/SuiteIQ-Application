package com.example.SuiteIQ.server_hcm_controller;

import com.example.SuiteIQ.server_hcm_domain.RoomType;
import com.example.SuiteIQ.server_hcm_service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-type")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;


    @GetMapping
    public List<RoomType> getAllRoomType() {
        return roomTypeService.getAllRoomTypes();
    }


    @GetMapping("/{id}")
    public RoomType getRoomTypeById(@PathVariable Long id) {
        return roomTypeService.getRoomTypeById(id);
    }


    @PostMapping
    public RoomType roomTypeEntity(@RequestBody RoomType roomType) {
        return roomTypeService.createRoomType(roomType);
    }


    @DeleteMapping("/{id}")
    public void deleteRoomType(@PathVariable Long id) {
        roomTypeService.deleteRoomType(id);
    }

    @PutMapping("/{id}")
    public RoomType updateRoomType(@PathVariable Long id, @RequestBody RoomType updatedRoomType) {
        return roomTypeService.updateRoomType(id, updatedRoomType);
    }

}
