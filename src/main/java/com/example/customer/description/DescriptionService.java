package com.example.customer.description;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionService(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    public List<Description> getDescriptions() {
        return descriptionRepository.findAll();
    }

    public Description getDescriptionById(Long descriptionId) {
        return descriptionRepository.findById(descriptionId)
                .orElseThrow(() -> new IllegalStateException("No Such Description With ID of " + descriptionId + " Exist"));
    }

//    @PostMapping
    public void addNewDescription(Description description) {
        Optional<Description> descriptionOptional = descriptionRepository.findByText(description.getText());
        if (descriptionOptional.isPresent()) {
            throw new IllegalStateException("This Description Already Exists");
        }
        descriptionRepository.save(description);
    }


    public void deleteDescription(Long descriptionId) {
        boolean exists = descriptionRepository.existsById(descriptionId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Tag With Id of " + descriptionId + " Exists"
            );
        }
        descriptionRepository.deleteById(descriptionId);
    }

    @Transactional
    public void updateDescription(Long descriptionId, String text) {
        Description description = descriptionRepository.findById(descriptionId)
                .orElseThrow(() -> new IllegalStateException("No Such Tag With Id of " + descriptionId + " Exists"));
        if (text != null && !text.isEmpty() && !Objects.equals(description.getText(), text)) {
            description.setText(text);
        }
    }
}
