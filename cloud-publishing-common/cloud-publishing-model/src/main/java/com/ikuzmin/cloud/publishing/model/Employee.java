package com.ikuzmin.cloud.publishing.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Igor Kuzmin
 */
@Data
@Entity
public class Employee implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer id;
  
  @Column(nullable = false)
  private String firstName;
  
  @Column(nullable = false)
  private String lastName;
  
  @Column
  private String middleName;
  
  @Column(nullable = false, unique = true)
  private String email;
  
  @Column(nullable = false)
  private String password;
  
  @Column(nullable = false)
  private Character sex;
  
  @Column(nullable = false)
  private Short birthYear;
  
  @Column(nullable = false)
  private String address;
  
  @Column(nullable = false)
  private Character type;
  
  @Column(nullable = true)
  private Integer educationId;
  
  @Column(nullable = false)
  private Boolean chiefEditor;
  
}
