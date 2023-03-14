package dk.kea.wishcloudone.Repository;

import dk.kea.wishcloudone.Models.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

}

