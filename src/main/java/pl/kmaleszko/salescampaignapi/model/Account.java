package pl.kmaleszko.salescampaignapi.model;

import org.hibernate.mapping.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(nullable = false, updatable = false)
  private Long id;
  private Set<Campaign> campaignSet;
}
