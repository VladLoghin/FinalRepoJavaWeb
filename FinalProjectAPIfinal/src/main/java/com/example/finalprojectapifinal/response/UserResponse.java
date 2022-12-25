package com.example.finalprojectapifinal.response;

import com.example.finalprojectapifinal.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String username;
    private long id;

    public UserResponse(User user){
        id=user.getId();
        username = user.getUsername();
    }
}
