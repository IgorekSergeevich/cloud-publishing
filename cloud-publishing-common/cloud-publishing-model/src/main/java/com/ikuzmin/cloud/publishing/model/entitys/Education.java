package com.ikuzmin.cloud.publishing.model.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author Igor Kuzmin
 */
@Data
@Entity
public class Education implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column
  private String title;
  
  @OneToMany(mappedBy = "education", fetch = FetchType.LAZY)
  private List<Employee> employees;
  
}
