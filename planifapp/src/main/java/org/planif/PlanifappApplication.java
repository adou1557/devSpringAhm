package org.planif;

import org.planif.dao.entity.Appointment;
import org.planif.dao.repository.EvenementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PlanifappApplication implements CommandLineRunner {

    private final EvenementRepository appointmentRepository;
    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**") // Map all paths under /api
                    .allowedOrigins("http://localhost:4200") // Allow requests from your frontend
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow necessary HTTP methods
                    .allowedHeaders("Authorization", "Content-Type"); // Allow specific headers
        }
    }
    public PlanifappApplication(EvenementRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Use a consistent date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Appointment> appointments = Arrays.asList(
                new Appointment(null,"Meeting with Bob", dateFormat.parse("2024-10-27"), "09:00", "10:00", "rgba(255, 0, 0, 0.4)"), // red
                new Appointment(null,"Lunch with Alice", dateFormat.parse("2024-10-02"), "12:00", "13:00", "rgba(0, 255, 0, 0.4)"), // green
                new Appointment(null,"Project Deadline", dateFormat.parse("2024-10-03"), "15:00", "16:00", "rgba(255, 255, 0, 0.4)"), // yellow
                new Appointment(null,"Doctor Appointment", dateFormat.parse("2024-10-27"), "10:00", "11:00", "rgba(0, 0, 255, 0.4)"), // blue
                new Appointment(null,"Team Meeting", dateFormat.parse("2024-10-28"), "14:00", "15:00", "rgba(128, 0, 128, 0.4)"), // purple
                new Appointment(null,"Coffee with Mike", dateFormat.parse("2024-10-27"), "11:00", "12:00", "rgba(255, 165, 0, 0.4)"), // orange
                new Appointment(null,"Client Call", dateFormat.parse("2024-10-31"), "09:30", "10:30", "rgba(0, 128, 128, 0.4)"), // teal
                new Appointment(null,"Gym", dateFormat.parse("2024-10-08"), "17:00", "18:00", "rgba(128, 128, 128, 0.4)"), // gray
                new Appointment(null,"Dentist Appointment", dateFormat.parse("2024-10-26"), "11:30", "12:30", "rgba(165, 42, 42, 0.4)"), // brown
                new Appointment(null,"Birthday Party", dateFormat.parse("2024-10-25"), "19:00", "21:00", "rgba(255, 192, 203, 0.4)"), // pink
                new Appointment(null,"Conference", dateFormat.parse("2024-10-11"), "13:00", "14:00", "rgba(0, 255, 255, 0.4)"), // cyan
                new Appointment(null,"Workshop", dateFormat.parse("2024-10-12"), "10:00", "12:00", "rgba(0, 255, 0, 0.4)"), // lime
                new Appointment(null,"Brunch with Sarah", dateFormat.parse("2024-10-13"), "11:00", "12:00", "rgba(255, 0, 255, 0.4)"), // magenta
                new Appointment(null,"Networking Event", dateFormat.parse("2024-10-29"), "18:00", "20:00", "rgba(0, 0, 255, 0.4)"), // blue
                new Appointment(null,"Yoga Class", dateFormat.parse("2024-10-16"), "07:00", "08:00", "rgba(0, 255, 0, 0.4)"), // green
                new Appointment(null,"Strategy Meeting", dateFormat.parse("2024-10-16"), "10:00", "11:30", "rgba(255, 0, 0, 0.4)"), // red
                new Appointment(null,"Call with Investor", dateFormat.parse("2024-10-17"), "14:00", "15:00", "rgba(255, 255, 0, 0.4)"), // yellow
                new Appointment(null,"Team Lunch", dateFormat.parse("2024-10-18"), "12:00", "13:00", "rgba(128, 0, 128, 0.4)"), // purple
                new Appointment(null,"HR Meeting", dateFormat.parse("2024-10-30"), "16:00", "17:00", "rgba(255, 165, 0, 0.4)"), // orange
                new Appointment(null,"Board Meeting", dateFormat.parse("2024-10-20"), "11:00", "12:00", "rgba(0, 0, 255, 0.4)") // blue
        );

        appointmentRepository.saveAll(appointments);
    }

    public static void main(String[] args) {
        SpringApplication.run(PlanifappApplication.class, args);
    }
}
