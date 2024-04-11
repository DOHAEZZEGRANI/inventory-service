package ma.xproce.inventoryservice.dao.repositories;
import jakarta.transaction.Transactional;
import ma.xproce.inventoryservice.dao.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Transactional
public interface VideoRepository extends JpaRepository<Video,Integer> {


    Page<Video> findByDescriptionContains(String keyword, Pageable pageable);
}



