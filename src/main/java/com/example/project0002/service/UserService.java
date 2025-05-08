package com.example.project0002.service;

import com.example.project0002.dto.LoginDTO;
import com.example.project0002.model.User;
import com.example.project0002.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(LoginDTO request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với username: " + request.getUsername()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Mật khẩu không đúng!");
        }

        return user;
    }

    // Create
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User với username " + user.getUsername() + " đã tồn tại!");
        }

        return userRepository.save(user);
    }

    // Read (all)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read (by ID)
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với ID: " + id));
    }

    // Update
    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với ID: " + id));

        // Kiểm tra trùng lặp username (trừ chính user đang cập nhật)
        Optional<User> existingUser = userRepository.findByUsername(userDetails.getUsername());
        if (existingUser.isPresent() && !existingUser.get().getId().equals(id)) {
            throw new IllegalArgumentException("User với username " + userDetails.getUsername() + " đã tồn tại!");
        }

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với ID: " + id));
        userRepository.delete(user);
    }

    // Search
    public List<User> searchUsers(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }
}