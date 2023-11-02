package com.mongo.mongodemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    @DBRef
    private Category category;

}
