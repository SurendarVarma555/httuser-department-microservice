package com.userservice.app.response;

import com.userservice.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Wrapper object contains both entity objects,we may use this object as response as either user or department
*
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartmentResponse {
    private User user;
    private Department department;

}
