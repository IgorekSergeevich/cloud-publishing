package com.ikuzmin.cloud.publishing.entitys;

import lombok.Data;

/**
 *
 * @author Igor Kuzmin
 */
@Data
public class Employee {

  public Employee(Integer id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  private Integer id;

  private String firstName;

  private String lastName;

  private String middleName;

  private String email;

  private String password;

  private Character sex;

  private Short birthYear;

  private String address;

  private Character type;

  private Integer educationId;

  private Boolean chiefEditor;
  
  public Boolean isChiefEditor() {
    return chiefEditor;
  }

}
