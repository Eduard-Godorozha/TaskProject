package com.eduard.restapiproject.service;

import com.eduard.restapiproject.web.dto.auth.JwtRequest;
import com.eduard.restapiproject.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
