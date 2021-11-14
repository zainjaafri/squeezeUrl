package com.squeezeUrl.squeezeUrl.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @GetMapping(path = "/squeezeUrl/{requestUrl}")
    public String getUrl(@PathVariable("requestUrl") String requestUrl){
        return urlService.getUrl(requestUrl);
    }

    @GetMapping(path = "/{requestUrl}")
    public RedirectView userUrl(@PathVariable("requestUrl") String requestUrl){
        return urlService.userUrl(requestUrl);
    }


}
