package com.example.customer.description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/description")
public class DescriptionController {
    private final DescriptionService descriptionService;

    @Autowired
    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @GetMapping
    public List<Description> getDescriptions() {
        return descriptionService.getDescriptions();
    }

    @GetMapping(path = "{descriptionId}")
    public Description descriptionById(@PathVariable("descriptionId") Long descriptionId) {
        return descriptionService.getDescriptionById(descriptionId);
    }

    @PostMapping
    public void registerNewDescription(@RequestBody Description description) {
        descriptionService.addNewDescription(description);
    }

    @DeleteMapping(path = "{descriptionId}")
    public void deleteDescription(@PathVariable("descriptionId") Long descriptionId) {
        descriptionService.deleteDescription(descriptionId);
    }

    @PutMapping(path = "{descriptionId}")
    public void updateDescription(@PathVariable("descriptionId") Long descriptionId, @RequestParam() String text) {
        descriptionService.updateDescription(descriptionId, text);
    }
}
