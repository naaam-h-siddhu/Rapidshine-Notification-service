package com.rapidshine.carwash.notification_service.messaging.rabbitmq;

import com.rapidshine.carwash.notification_service.dto.BookingCreatedEvent;
import com.rapidshine.carwash.notification_service.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookingEvenListener {
    private final EmailService emailService;
    public BookingEvenListener(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues = "booking.notification")
    public void handleBookingCreated(BookingCreatedEvent event){        System.out.println("MESSAGE SENT");


        String subject = "Booking Confirmed: "+event.getBookingId();
        String html = "Hi\n"
                + "Your booking has been confirmed.\n"
                + "Booking ID: " + event.getBookingId()
                + "\n\nThank you for booking with us!";
        emailService.sendSimpleEmail(event.getEmail(),subject,html);
        System.out.println("MESSAGE SENT");
    }
}
