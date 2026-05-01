package com.data.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.DTO.AuthRequest;
import com.data.DTO.AuthResponse;
import com.data.DTO.RegisterRequest;
import com.data.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
	public class AuthController {

	    private final AuthService authService;

	    @PostMapping("/register")
	    public AuthResponse register(@RequestBody RegisterRequest request) {
	        return authService.register(request);
	    }

	    @PostMapping("/login")
	    public AuthResponse login(@RequestBody AuthRequest request) {
	        return authService.login(request);
	    }
	}

