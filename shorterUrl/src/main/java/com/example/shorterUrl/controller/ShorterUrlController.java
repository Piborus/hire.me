package com.example.shorterUrl.controller;

import com.example.shorterUrl.service.ShorterUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShorterUrlController {

    @Autowired
    private ShorterUrlService shorterUrlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String longUrl) {
        String shortUrl = shorterUrlService.shortenUrl(longUrl);
        return "Shortened URL: " + shortUrl;//ajeita
    }

    @GetMapping("{shortUrl}")
    public String expandUrl(@PathVariable String shortUrl) {
        String longUrl = shorterUrlService.expandUrl(shortUrl);
        if (longUrl != null) {
            return "Expanded URL: " + longUrl;//ajeita
        } else {
            return "URL not found";//ajeita
        }
    }

    @GetMapping("/isPresent/{shortUrl}")
    public String isShortUrlPresent(@PathVariable String shortUrl) {
        boolean isPresent = shorterUrlService.isShortUrlPresent(shortUrl);
        if (isPresent) {
            return "Short URL is present in the database.";//ajeita
        } else {
            return "Short URL is not present in the database.";//ajeita
        }
    }
}
