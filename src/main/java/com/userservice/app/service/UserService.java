package com.userservice.app.service;

import com.userservice.app.entity.User;
import com.userservice.app.repository.UserRepository;
import com.userservice.app.response.Department;
import com.userservice.app.response.UserWithDepartmentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }
    /* To get department details with USER then we need to communicate the department from User service with the help of RestTemplate */
    public UserWithDepartmentResponse findUserWithDepartment(Long userId) {
        UserWithDepartmentResponse response = new UserWithDepartmentResponse();
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        response.setUser(user);
        response.setDepartment(department);

        return response;
    }
}
