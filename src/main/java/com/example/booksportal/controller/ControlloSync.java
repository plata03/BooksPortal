package com.example.booksportal.controller;

import com.example.booksportal.dao.DaoBook;
import com.example.booksportal.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sincronizza")
public class ControlloSync {

    private final RestTemplate restTemplate;

    @Autowired
    private DaoBook bookRepository;

    @Autowired
    public ControlloSync(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String sincronizzaLibri() {
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=spring%20framework";

        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(apiUrl, Map.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = responseEntity.getBody();
            if (responseBody != null) {
                List<Map<String, Object>> items = (List<Map<String, Object>>) responseBody.get("items");

                for (Map<String, Object> item : items) {

                    String bookId = (String) item.get("id");
                    String title = (String) ((Map<String, Object>) item.get("volumeInfo")).get("title");
                    String author = "AUTH_"+bookId;
                    String release_year = (String) ((Map<String, Object>) item.get("volumeInfo")).get("publishedDate");
                    String price = "6,9€";
                    String publisher = (String) ((Map<String, Object>) item.get("volumeInfo")).get("publisher");

                    Book libro = new Book(title, author, release_year, price, publisher);
                    bookRepository.save(libro);


                }

                return "Sincronizzazione completata";
            }
        }

        return "Errore durante la sincronizzazione";
    }
}
