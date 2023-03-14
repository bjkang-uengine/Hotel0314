package hotel.domain;

import hotel.domain.*;
import hotel.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;

    public Reserved(Reservation aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
