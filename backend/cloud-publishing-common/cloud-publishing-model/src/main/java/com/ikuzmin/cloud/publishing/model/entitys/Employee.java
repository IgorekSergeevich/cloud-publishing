package com.ikuzmin.cloud.publishing.model.entitys;

import com.ikuzmin.cloud.publishing.model.roles.EmployeeType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  private Integer id;
  
  @Column(nullable = false, unique = true)
  private String login;
  
  @Column(nullable = false, name = "first_name")
  private String firstName;
  
  @Column(nullable = false, name = "last_name")
  private String lastName;
  
  @Column(name = "middle_name")
  private String middleName;
  
  @Column(nullable = false, unique = true)
  private String email;
  
  @Column(nullable = false)
  private String password;
  
  @Column(nullable = false)
  private Character sex;
  
  @Column(nullable = false, name = "birth_year")
  private Short birthYear;
  
  @Column(nullable = false)
  private String address;
  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EmployeeType type;
  
  @ManyToOne
  @JoinColumn(name = "education_id", nullable = true)
  private Education education;
  
  @Column(nullable = false, name = "chief_editor")
  private Boolean chiefEditor;
  
}
