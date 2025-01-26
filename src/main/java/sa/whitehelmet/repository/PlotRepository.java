package sa.whitehelmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sa.whitehelmet.model.Plot;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

    @Query(value = "select id from plot where (irrigated_at  + (irrigation_period_in_hours || ' hours')::interval) < current_timestamp;", nativeQuery = true)
    List<Long> getAllPlotsToIrrigate();
}
