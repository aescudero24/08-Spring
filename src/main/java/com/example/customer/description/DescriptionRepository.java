package com.example.customer.description;

import com.example.customer.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
    @Query("SELECT s FROM Description s WHERE s.text = ?1")
    Optional<Description> findByText(String text);
}
