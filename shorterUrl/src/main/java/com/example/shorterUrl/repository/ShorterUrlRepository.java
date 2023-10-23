package com.example.shorterUrl.repository;

import com.example.shorterUrl.model.ShorterUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShorterUrlRepository extends JpaRepository<ShorterUrl, Long> {

    ShorterUrl findByShortUrl(String shortUrl);

    ShorterUrl findByLongUrl(String longUrl);
}
