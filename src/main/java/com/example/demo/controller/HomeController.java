package com.example.demo.controller;

import com.example.demo.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<Event> events = List.of(
            new Event(
                "Spring Conference 2026",
                "2026-11-15",
                "Tech Center Downtown",
                "Join us for the annual Spring Framework conference featuring expert speakers, workshops, and networking opportunities."
            ),
            new Event(
                "Jazz Night Under the Stars",
                "2026-11-20",
                "Riverside Music Hall",
                "An evening of smooth jazz featuring local and international artists in an intimate venue setting."
            ),
            new Event(
                "Community Coding Workshop",
                "2026-12-01",
                "Innovation Hub Community Center",
                "Free hands-on coding workshop for beginners. Learn the basics of web development in a supportive environment."
            ),
            new Event(
                "New Year's Tech Expo",
                "2026-12-28",
                "Convention Center Hall A",
                "Explore the latest technology innovations, meet industry leaders, and discover cutting-edge products and solutions."
            )
        );
        
        model.addAttribute("events", events);
        return "index";
    }
}
