package hotel.domain;

import hotel.ReserveApplication;
import hotel.domain.Reserved;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        hotel.external.Notification notification = new hotel.external.Notification();
        // mappings goes here
        ReserveApplication.applicationContext
            .getBean(hotel.external.NotificationService.class)
            .notifyToCustomaer(notification);

        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReserveApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
