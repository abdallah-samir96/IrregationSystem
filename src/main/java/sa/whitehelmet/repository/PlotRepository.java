package sa.whitehelmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.whitehelmet.model.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
}
