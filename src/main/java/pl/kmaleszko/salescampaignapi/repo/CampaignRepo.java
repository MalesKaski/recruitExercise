package pl.kmaleszko.salescampaignapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kmaleszko.salescampaignapi.model.Campaign;

import java.util.Optional;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Long> {
  Optional<Campaign> findCampaignById(Long id);
}
