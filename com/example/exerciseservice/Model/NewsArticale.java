package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticale {

    @NotNull(message = "ID cannot be null !")
    private int id;

    @NotEmpty(message = "Title cannot be empty !")
    @Size(max = 100, message = "Title cannot be more than 100 characters !")
    private String title;

    @NotEmpty(message = "Author cannot be empty !")
    @Size(min = 4, max = 20,message = "Author should more than 4 chars and less than 20 !")
    private String author;

    @NotEmpty(message = "Content cannot be empty !")
    @Size(max = 200,message = "Content cannot be more than 200 characters !")
    private String content;

    @NotEmpty(message = "Category cannot be empty !")
    @Pattern(regexp = "^(politics|sports|technology)$",message = "Category should be 'politics' OR 'sports' OR 'technology' !")
    private String category;

    @NotEmpty(message = "imageUrl cannot be empty !")
    private String imageUrl;

    @AssertFalse
    private boolean isPublished;

    @NotNull(message = "Publish Date cannot be Empty!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

}
