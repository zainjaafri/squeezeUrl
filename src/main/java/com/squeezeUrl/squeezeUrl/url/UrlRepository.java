package com.squeezeUrl.squeezeUrl.url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {

    Optional<Url> findByUrl(String url);
    Optional<Url> getUrlByUrl(String url);
}
