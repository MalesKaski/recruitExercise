package pl.kmaleszko.salescampaignapi.exception;

public class CampaignNotFoundException extends RuntimeException {
  public CampaignNotFoundException(String message) {
    super(message);
  }
}
