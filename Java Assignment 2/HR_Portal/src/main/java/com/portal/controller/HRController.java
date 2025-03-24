package com.portal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.HR;
import com.portal.service.HRService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/hr")
public class HRController {
	
	@Autowired
    private HRService hrService;
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Map<String, String> logindata, HttpServletRequest request) {
	        String email = logindata.get("email");
	        String password = logindata.get("password");

	        HR hr = hrService.findByEmail(email);

	        if (hr != null && hr.getPassword().equals(password)) {
	            request.getSession().setAttribute("hrEmail", email);
	            return ResponseEntity.ok("Login Successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
	        }
	    }
	 
	 @PostMapping("/logout")
	 public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // Destroy the session
			return ResponseEntity.ok("Logged out successfully");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No active session found");
		}

	 }

}
