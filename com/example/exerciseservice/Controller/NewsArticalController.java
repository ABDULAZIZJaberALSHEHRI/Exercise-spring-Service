package com.example.exerciseservice.Controller;

import com.example.exerciseservice.Model.NewsArticale;
import com.example.exerciseservice.Service.NewsArticaleService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/newsarticale")
@RequiredArgsConstructor
public class NewsArticalController {
    private final NewsArticaleService newsArticaleService;


    @GetMapping("/get-newsarticale")
    public ResponseEntity getAllNewsArticale(){
        ArrayList<NewsArticale> newsArticales = newsArticaleService.getNewsArticaleList();
        return ResponseEntity.status(200).body(newsArticales);
    }

    @PostMapping("/add-newsarticale")
    public ResponseEntity addNewsArticale(@Valid @RequestBody NewsArticale newsArticale, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsArticaleService.addNewsArticale(newsArticale);
        return ResponseEntity.status(200).body("News Article added");
    }

    @PutMapping("/update-newsarticale/{id}")
    public ResponseEntity updateNewsArticale(@PathVariable int id, @Valid @RequestBody NewsArticale newsArticale, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = newsArticaleService.updateNewsArticale(id, newsArticale);
        if(isUpdated){
            return ResponseEntity.status(200).body("News Article updated");
        }
        return ResponseEntity.status(400).body("ID not found");
    }

    @DeleteMapping("/del-newsarticale/{id}")
    public ResponseEntity deleteNewsArticale(@PathVariable int id){
        boolean isDeleted = newsArticaleService.deleteNewsArticale(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("News Article deleted");
        }
        return ResponseEntity.status(400).body("ID not found");
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publishNewsArticale(@PathVariable int id){
        boolean isPublished = newsArticaleService.published(id);
        if(isPublished){
            return ResponseEntity.status(200).body("News Article published");
        }
        return ResponseEntity.status(400).body("ID not found");
    }

    @GetMapping("/get-published")
    public ResponseEntity getPublishedNews(){
        if (newsArticaleService.getPublishedNewsArticles()==null){
            return ResponseEntity.status(400).body("No published News Article found");
        }
        return ResponseEntity.status(200).body(newsArticaleService.getPublishedNewsArticles());
    }

    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
//        ArrayList<NewsArticale>  n = newsArticaleService.getByCategory(category);
        if (newsArticaleService.getByCategory(category)==null){
            return ResponseEntity.status(400).body("No News Article found");
        }
        return ResponseEntity.status(200).body(newsArticaleService.getByCategory(category));
    }

}
