package controller;

import dao.EventDAO;
import model.EventRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventDAO eventDAO;

    @GetMapping("/")
    public String showForm(Model model, @ModelAttribute("msg") String msg) {
        model.addAttribute("registration", new EventRegistration());

        // Dropdown events
        List<String> events = List.of("Tech Talk", "Workshop", "Hackathon", "Seminar");
        model.addAttribute("events", events);

        // Optional: Flash message
        model.addAttribute("msg", msg);

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute EventRegistration registration,
                               RedirectAttributes redirectAttributes) {
        eventDAO.save(registration);

        // Flash success message
        redirectAttributes.addFlashAttribute("msg", "✅ Registration successful!");
        return "redirect:/"; // Redirecting to home (register.jsp)
    }

    @GetMapping("/participants")
    public String viewParticipants(Model model) {
        List<EventRegistration> list = eventDAO.getAll();
        model.addAttribute("list", list);
        return "viewParticipants";
    }
}
