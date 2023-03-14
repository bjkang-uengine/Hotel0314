package hotel.infra;

import hotel.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "roomSearches",
    path = "roomSearches"
)
public interface RoomSearchRepository
    extends PagingAndSortingRepository<RoomSearch, Long> {}
