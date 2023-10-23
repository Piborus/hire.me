package com.example.shorterUrl.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "shortUrl")
@Entity(name = "shortUrl")
public class ShorterUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shortUrl")
    private String shortUrl;

    @Column(name = "longUrl")
    private String longUrl;
}
