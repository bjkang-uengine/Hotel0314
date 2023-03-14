package hotels.external;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    /**
     * Fallback
     */
    public Notification getNotification(Long id) {
        Notification notification = new Notification();
        return notification;
    }
}
