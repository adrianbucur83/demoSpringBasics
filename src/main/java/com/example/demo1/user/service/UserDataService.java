package com.example.demo1.user.service;

import com.example.demo1.user.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserDataService {
  private static List<User> users = new ArrayList<>();
  private static int userIdCounter = 1;

  static {
    users.add(new User(userIdCounter++, "Stefan", "Patrascu", "stefanpatrascu@example.com"));
  }
  public void populateUsersModel(Model model, Integer id) {
    model.addAttribute("users", users);

    if (id != null) {
      User userToUpdate = getUserById(id);
      model.addAttribute("userToUpdate", userToUpdate);
    }

  }

  public User getUserById(Integer userId) {
    return users.stream().filter(user -> user.getId() == userId).findFirst().orElse(null);
  }

  public void addUser(String firstName, String lastName, String email) {
    users.add(new User(userIdCounter++, firstName, lastName, email));
  }

  public void deleteUser(int id) {
    users.removeIf(user -> user.getId() == id);
  }

  public void updateUser(int id, String firstName, String lastName, String email) {
    users.stream().filter(user -> user.getId() == id).findFirst().ifPresent(user -> {
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setEmail(email);
    });
  }
}
