package com.betrybe.agrix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


/**
 * The type Farm.
 */
@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double size;

  @OneToMany(mappedBy = "farm")
  @JsonIgnore
  private List<Crop> crops;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "farm_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  @JsonIgnore
  private List<Fertilizer> fertilizers;

  /**
   * Instantiates a new Farm.
   */
  public Farm() {}

  /**
   * Instantiates a new Farm.
   *
   * @param id          the id
   * @param name        the name
   * @param size        the size
   * @param fertilizers the fertilizers
   */
  public Farm(Long id, String name, Double size, List<Fertilizer> fertilizers) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.fertilizers = fertilizers;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public Double getSize() {
    return size;
  }

  /**
   * Sets size.
   *
   * @param size the size
   */
  public void setSize(Double size) {
    this.size = size;
  }

  /**
   * Gets crops.
   *
   * @return the crops
   */
  public List<Crop> getCrops() {
    return crops;
  }

  /**
   * Sets crops.
   *
   * @param crops the crops
   */
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }

  /**
   * Gets fertilizers.
   *
   * @return the fertilizers
   */
  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  /**
   * Sets fertilizers.
   *
   * @param fertilizers the fertilizers
   */
  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
