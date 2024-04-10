package com.example.demo1.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
}
