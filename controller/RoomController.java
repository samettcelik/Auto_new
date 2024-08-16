package com.demo.authdemo.controller;

import com.demo.authdemo.entity.Room;
import com.demo.authdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{subId}")
    public List<Room> getRoomsBySubId(@PathVariable Long subId) {
        return roomService.getRoomsBySubId(subId);
    }

    @PostMapping("/select")
    public ResponseEntity<String> selectRoom(@RequestBody Room room) {
        // Oda seçildiğinde yapılacak işlemleri burada belirleyebilirsiniz
        return ResponseEntity.ok("Room " + room.getOdaNum() + " selected");
    }
}
