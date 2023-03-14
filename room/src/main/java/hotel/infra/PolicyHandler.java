package hotel.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotel.config.kafka.KafkaProcessor;
import hotel.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RoomRepository roomRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reserved'"
    )
    public void wheneverReserved_RoomInfoUpdate(@Payload Reserved reserved) {
        Reserved event = reserved;
        System.out.println(
            "\n\n##### listener RoomInfoUpdate : " + reserved + "\n\n"
        );

        // Sample Logic //
        Room.roomInfoUpdate(event);
    }
}
