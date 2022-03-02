package com.app.NeptuneDemo.controller;

import com.app.NeptuneDemo.model.Event;
import com.app.NeptuneDemo.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminEventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/admin/manage-event")
    public String index(Model model) {
        model.addAttribute("event", eventService.index());
        return "adminEvent";
    }

    @GetMapping("/admin/insert-event")
    public String insert(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "admin_form_event";
    }

    @PostMapping("/admin/save-event")
    public String save(Event event) {
        eventService.save(event);
        return "redirect:/admin/manage-events";
    }

    @GetMapping("/admin/edit-event/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Event event = eventService.show(id);
        model.addAttribute("event", event);
        return "admin_form_event";
    }

    @GetMapping("/admin/destroy-event")
    public String delete(Long id) {
        eventService.delete(id);
        return "redirect:/admin/manage-events";
    }
}
