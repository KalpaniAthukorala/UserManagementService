package com.example.userms.repo;

import com.example.userms.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PreferenceRepo extends JpaRepository<Preference,Integer> {
}
