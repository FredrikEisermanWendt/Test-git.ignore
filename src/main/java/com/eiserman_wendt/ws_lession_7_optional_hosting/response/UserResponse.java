package com.eiserman_wendt.ws_lession_7_optional_hosting.response;

import com.eiserman_wendt.ws_lession_7_optional_hosting.model.User;

public class UserResponse extends User implements WsResponse {
    
    public UserResponse() {
    }
    
    public UserResponse(User user){
        super(user.getUsername(), user.getPassword());
    }
    
    
    public UserResponse(String username, String password) {
        super(username, password);
    }
    
    
}
