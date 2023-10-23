package com.example.shorterUrl.service;

import com.example.shorterUrl.model.ShorterUrl;
import com.example.shorterUrl.repository.ShorterUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Random;

@Service
public class ShorterUrlService {

    @Autowired
    private ShorterUrlRepository shorterUrlRepository;

    public String shortenUrl(String longUrl) {
        // Verifique se a URL longa já foi encurtada
        ShorterUrl existingShortUrl = shorterUrlRepository.findByLongUrl(longUrl);
        if (existingShortUrl != null) {
            return existingShortUrl.getShortUrl();
        } else {
            // Crie e salve uma nova URL encurtada
            String shortUrl = generateShortUrl();
            ShorterUrl newShorterUrl = new ShorterUrl();
            newShorterUrl.setLongUrl(longUrl);
            newShorterUrl.setShortUrl(shortUrl);
            shorterUrlRepository.save(newShorterUrl);
            return shortUrl;
        }
    }

    public String expandUrl(String shortUrl) {
        ShorterUrl shorterUrl = shorterUrlRepository.findByShortUrl(shortUrl);
        if (shorterUrl != null) {
            return shorterUrl.getLongUrl();
        } else {
            return null; // URL curta não encontrada
        }
    }

    public boolean isShortUrlPresent(String shortUrl) {
        ShorterUrl shorterUrl = shorterUrlRepository.findByShortUrl(shortUrl);
        return shorterUrl != null;
    }

    private String generateShortUrl() {
        Random random = new Random();
        byte[] randomBytes = new byte[6]; // Tamanho personalizável
        random.nextBytes(randomBytes);
        String shortUrl = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        return shortUrl;
    }
}
