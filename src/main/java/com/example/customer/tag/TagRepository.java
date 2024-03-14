package com.example.customer.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT s FROM Tag s WHERE s.tag_name = ?1")
    Optional<Tag> findTagByName(String tagName);
}
