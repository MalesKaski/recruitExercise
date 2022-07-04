package pl.kmaleszko.salescampaignapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmaleszko.salescampaignapi.exception.CampaignNotFoundException;
import pl.kmaleszko.salescampaignapi.model.Campaign;
import pl.kmaleszko.salescampaignapi.repo.CampaignRepo;

import java.util.List;

@Service
public class CampaignService {
  private final CampaignRepo campaignRepo;

  @Autowired
  public CampaignService(CampaignRepo campaignRepo) {
    this.campaignRepo = campaignRepo;
  }

  public Campaign addCampaign(Campaign campaign) {
    return campaignRepo.save(campaign);
  }

  public Campaign updateCampaign(Campaign campaign) {
    return campaignRepo.save(campaign);
  }

  public List<Campaign> findAllCampaigns() {
    return campaignRepo.findAll();
  }

  public Campaign findCampaignById(Long id) {
    return campaignRepo.findCampaignById(id)
        .orElseThrow(() -> new CampaignNotFoundException("Campaign by id " + id + " was not found."));
  }

  public void deleteCampaignById(Long id) {
    campaignRepo.deleteById(id);
  }
}
