package hotels.domain;

import hotels.NotifyApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {}

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotifyApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
