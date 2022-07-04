package pl.kmaleszko.salescampaignapi.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Campaign implements Serializable {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(nullable = false, updatable = false)
  private Long id;
  @NonNull
  @ManyToOne
  private Account account;
  private String campaignName;
  private double campaignFund;
  private boolean status;

  public Campaign() {
  }

  public Campaign(String campaignName, double campaignFund, boolean status) {
    this.campaignName = campaignName;
    this.campaignFund = campaignFund;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  public double getCampaignFund() {
    return campaignFund;
  }

  public void setCampaignFund(double campaignFund) {
    this.campaignFund = campaignFund;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Campaign{" +
        "id=" + id +
        ", campaignName='" + campaignName + '\'' +
        ", campaignFund=" + campaignFund +
        ", status=" + status +
        '}';
  }
}
