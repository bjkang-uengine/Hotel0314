package hotel.domain;

import hotel.domain.*;
import hotel.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RoomInfoModified extends AbstractEvent {

    private Long id;

    public RoomInfoModified(Room aggregate) {
        super(aggregate);
    }

    public RoomInfoModified() {
        super();
    }
}
