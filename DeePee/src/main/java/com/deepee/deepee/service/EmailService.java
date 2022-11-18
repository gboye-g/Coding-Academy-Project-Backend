package com.deepee.deepee.service;

public interface EmailService {
    void sendEmail(String to,String subject,String body);

    void sendTripRequestRejectedEmail();

    void sendTripRequestAcceptedEmail();

    void sendTripUpdatedEmail();

    void sendTripCanceledEmail();
}
