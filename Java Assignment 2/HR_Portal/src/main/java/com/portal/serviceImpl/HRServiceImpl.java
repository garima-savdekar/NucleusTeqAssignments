package com.portal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.portal.model.HR;
import com.portal.repository.HRRepository;
import com.portal.service.HRService;

@Service
public class HRServiceImpl implements HRService{
	
	@Autowired
    private HRRepository hrRepository;

    public HR findByEmail(String email) {
        return hrRepository.findByEmail(email);
    }
}
