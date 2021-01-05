package com.building.service;

public interface EmailService {
    String acceptOrderMail(String userName, String userEmail);

    String completeOrderMail(String userName, String userEmail);
}
