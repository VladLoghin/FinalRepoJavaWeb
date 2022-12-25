package com.example.finalprojectapifinal.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    @NotBlank
    private long Id;

    @NotBlank
    private String username;

    public UserRequest(UserRequest userRequest){
        Id=userRequest.getId();
        username=userRequest.getUsername();
    }
}
