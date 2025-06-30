package com.teach.crud.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer yearPublication;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    public BookModel(Long id, String title, Integer yearPublication) {
        this.id = id;
        this.title = title;
        this.yearPublication = yearPublication;
    }

    public BookModel(String title, Integer yearPublication) {
        this.title = title;
        this.yearPublication = yearPublication;
    }


    public BookModel() {
    }

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

    public Integer getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Integer yearPublication) {
        this.yearPublication = yearPublication;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    @PreUpdate
    public void setUpdateAt() {
        this.updateAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
