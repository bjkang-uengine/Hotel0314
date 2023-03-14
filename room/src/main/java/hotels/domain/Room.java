package hotels.domain;

import hotels.RoomApplication;
import hotels.domain.RoomInfoModified;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Room_table")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        RoomInfoModified roomInfoModified = new RoomInfoModified(this);
        roomInfoModified.publishAfterCommit();
    }

    public static RoomRepository repository() {
        RoomRepository roomRepository = RoomApplication.applicationContext.getBean(
            RoomRepository.class
        );
        return roomRepository;
    }

    //<<< Clean Arch / Port Method
    public static void roomInfoUpdate(Reserved reserved) {
        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
