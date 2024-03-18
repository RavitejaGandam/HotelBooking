package com.ravi.hotelbooking.service;

import com.ravi.hotelbooking.entity.Room;
import com.ravi.hotelbooking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class IRoomServcieImpl implements IRoomService {
    private final RoomRepository roomRepository;
    @Override
    public Room addNewRoom(MultipartFile file,
                           String roomType,
                           BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        byte[] photoBytes = new byte[0];
        if (!file.isEmpty()) {
            photoBytes = file.getBytes();
        }
        Blob photoBlob = new SerialBlob(photoBytes);
        room.setPhoto(photoBlob);
        return roomRepository.save(room);
    }
}
