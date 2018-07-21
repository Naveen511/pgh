package com.niche.controller;

import com.niche.exception.ResourceNotFoundException;
import com.niche.model.User;
import com.niche.repository.UserRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * used for main operations such as CRUD.
 * @author niche0033
 *
 */

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
     * Load all the user from table using Interface (UserRepository)
     * @return Array of users
     */
    @GetMapping("/userlist")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    /**
     * Add a new user to a table using Interface (UserRepository)
     * @param user Object with entity
     * @return Object of user details
     */
    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user) {
        // System.out.println("user : " + user);
        return userRepository.save(user);
    }
    
    /**
     * Get the particular user details using id
     * @param userId auto increment id of user table
     * @return object
     */
    @GetMapping("/view/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }
    
    /**
     * Load the particular user details using id and update the value
     * @param userId auto increment id of user table
     * @param userDetails Object of entity values
     * @return Object of user details
     */
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setEmail_id(userDetails.getEmail_id());
        user.setFirst_name(userDetails.getFirst_name());
        user.setLast_name(userDetails.getLast_name());
        user.setUser_name(userDetails.getUser_name());
        user.setContact_no(userDetails.getContact_no());       

        User updatedUserDetails = userRepository.save(user);
        return updatedUserDetails;
    }
    
    /**
     * Delete a particular user details from a table
     * @param userId auto increment id of user table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
