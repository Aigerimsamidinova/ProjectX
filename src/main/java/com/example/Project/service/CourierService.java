package com.example.Project.service;

import com.example.Project.model.Application;

public interface CourierService {
    Application changeApplicationStatus(Long courierId, Long appId, String code);
}
