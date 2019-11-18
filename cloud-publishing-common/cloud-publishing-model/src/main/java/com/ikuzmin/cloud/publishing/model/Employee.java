/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikuzmin.cloud.publishing.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Igor Kuzmin
 */
@Data
//@Entity
public class Employee implements Serializable {
  
  /*@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column*/
  private Integer id;
  
  //@Column(nullable = false)
  private String firstName;
  
  //@Column(nullable = false)
  private String lastName;
  
  //@Column
  private String middleName;
  
  //@Column(nullable = false, unique = true)
  private String email;
  
  //@Column(nullable = false)
  private String password;
  
  //@Column(nullable = false)
  private Character sex;
  
  //@Column(nullable = false)
  private Short birthYear;
  
  //@Column(nullable = false)
  private String address;
  
  //@Column(nullable = false)
  private Character type;
  
  //@Column(nullable = true)
  private Integer educationId;
  
  //@Column(nullable = false)
  private Boolean chiefEditor;
  
}
