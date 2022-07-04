package pl.kmaleszko.salescampaignapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kmaleszko.salescampaignapi.model.Campaign;
import pl.kmaleszko.salescampaignapi.service.CampaignService;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignResource {
  private final CampaignService campaignService;

  public CampaignResource(CampaignService campaignService) {
    this.campaignService = campaignService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Campaign>> getAllCampaigns() {
    List<Campaign> campaigns = campaignService.findAllCampaigns();
    return new ResponseEntity<>(campaigns, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Campaign> getCampaignById(@PathVariable("id") Long id) {
    Campaign campaign = campaignService.findCampaignById(id);
    return new ResponseEntity(campaign, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
    Campaign newCampaign = campaignService.addCampaign(campaign);
    return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaign) {
    Campaign updateCampaign = campaignService.updateCampaign(campaign);
    return new ResponseEntity<>(updateCampaign, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteCampaignById(@PathVariable("id") Long id) {
    campaignService.deleteCampaignById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}