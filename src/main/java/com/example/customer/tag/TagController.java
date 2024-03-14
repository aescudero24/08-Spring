package com.example.customer.tag;

import com.example.customer.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tag")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @GetMapping(path = "{tagId}")
    public Tag tagById(@PathVariable("tagId") Long tagId) {
        return tagService.getTagById(tagId);
    }

    @PostMapping
    public void registerNewTag(@RequestBody Tag tag) {
        tagService.addNewTag(tag);
    }

    @DeleteMapping(path = "{tagId}")
    public void deleteTag(@PathVariable("tagId") Long tagId) {
        tagService.deleteTag(tagId);
    }

    @PutMapping(path = "{tagId}")
    public void updateTag(@PathVariable("tagId") Long tagId, @RequestParam() String tag_name) {
        tagService.updateTag(tagId, tag_name);
    }
}
