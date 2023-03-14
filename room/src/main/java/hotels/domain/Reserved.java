package hotels.domain;

import hotels.domain.*;
import hotels.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
}
