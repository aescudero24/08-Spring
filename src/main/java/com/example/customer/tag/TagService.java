package com.example.customer.tag;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() -> new IllegalStateException("No Such Tag With ID of " + tagId + " Exist"));
    }

    @PostMapping
    public void addNewTag(Tag tag) {
        Optional<Tag> tagOptional = tagRepository.findTagByName(tag.getTag_name());
        if (tagOptional.isPresent()) {
            throw new IllegalStateException("This Tag Already Exists");
        }
        tagRepository.save(tag);
    }

    public void deleteTag(Long tagId) {
        boolean exists = tagRepository.existsById(tagId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Tag With Id of " + tagId + " Exists"
            );
        }
        tagRepository.deleteById(tagId);
    }

    @Transactional
    public void updateTag(Long tagId, String tag_name) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new IllegalStateException("No Such Tag With Id of " + tagId + " Exists"));
        if (tag_name != null && !tag_name.isEmpty() && !Objects.equals(tag.getTag_name(), tag_name)) {
            tag.setTag_name(tag_name);
        }
    }
}
