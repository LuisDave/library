package com.onlinelibrary.management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

@Schema(description = "Data Transfer Object for Book")
public class BookDTO {

    @JsonIgnore
    @Schema(description = "ID of the book", example = "1")
    private Long id;

    @Size(max = 60)
    @Schema(description = "Title of the book", example = "The Great Gatsby")
    private String title;

    @Size(max = 60)
    @Schema(description = "Author of the book", example = "F. Scott Fitzgerald")
    private String author;

    @Schema(description = "ISBN number of the book", example = "9783161484100")
    private String isbn;

    @Schema(description = "Publisher of the book", example = "Charles Scribner's Sons")
    private String publisher;

    @Schema(description = "Publication date of the book", example = "1925-04-10")
    private LocalDate publicationDate;

    @Schema(description = "Price of the book", example = "10.99")
    private Double price;

    @Schema(description = "Type of the book", example = "1", allowableValues = {"1", "2", "3", "4", "5", "6"})
    private Integer type;

    @JsonIgnore
    @Schema(description = "Whether the book is active", example = "true")
    private Boolean active;

    @JsonIgnore
    @Schema(description = "The time when the book was created", example = "2024-06-01T12:00:00")
    private LocalDateTime creationTime;

    @JsonIgnore
    @Schema(description = "The time when the book was last updated", example = "2024-06-01T12:00:00")
    private LocalDateTime updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
