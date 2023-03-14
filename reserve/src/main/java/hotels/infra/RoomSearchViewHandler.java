package hotels.infra;

import hotels.config.kafka.KafkaProcessor;
import hotels.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RoomSearchViewHandler {

    @Autowired
    private RoomSearchRepository roomSearchRepository;
}
