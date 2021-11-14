package com.squeezeUrl.squeezeUrl.url;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UrlService {
    String[] urlArray = new String[10];
    String[] shortUrlArray = new String[10];
    static int id = 1000000000;
    int count = 0;

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public RedirectView userUrl(String requestUrl){
        RedirectView redirectView = new RedirectView();
        System.out.println(requestUrl);
        Optional<Url> optionalProduct = null;
        //System.out.println(optionalProduct);
        try{
            optionalProduct = urlRepository.getUrlByUrl(requestUrl);
            String getShortUrl = optionalProduct.get().getShort_url();
            redirectView.setUrl(getShortUrl);
            return redirectView;
        }catch (NoSuchElementException e){
            System.out.println(id);
            String shortUrl = "https://www.shorturl.com/"+encodeUrl(id++);
            Url url = new Url(requestUrl,shortUrl);
            System.out.println(url);
            urlRepository.save(url);
            redirectView.setUrl(shortUrl);
            return redirectView;
        }
    }

    public String encodeUrl(int id){
        char[] characters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m'
                ,'n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M'
                ,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int base = characters.length;

        StringBuilder encodedUrl = new StringBuilder();

        while(id>0){
            int val = id%base;
            encodedUrl.append(characters[val]);
            id = id/base;
        }
        return encodedUrl.reverse().toString();
    }

    public String getUrl(String requestUrl){
        Optional<Url> optionalProduct = null;
        String shortUrl="";
        try{
            optionalProduct = urlRepository.getUrlByUrl(requestUrl);
            shortUrl = optionalProduct.get().getShort_url();
            return shortUrl;
        }catch (NoSuchElementException e){
            System.out.println(id);
            shortUrl = "https://www.shorturl.com/"+encodeUrl(id++);
            Url url = new Url(requestUrl,shortUrl);
            System.out.println(url);
            urlRepository.save(url);
            return shortUrl;
        }
    }
}
