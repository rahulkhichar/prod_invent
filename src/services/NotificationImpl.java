package services;


import interfaces.NotificationService;

public class NotificationImpl implements NotificationService {
    @Override
    public void sendNotification(String message) {

        System.out.println("Sending notification: " + message);

    }
}
