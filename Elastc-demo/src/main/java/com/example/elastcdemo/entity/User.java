package com.example.elastcdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "user-demo")
public class User {
    @Id
    private String id;
    private String username;
    private String address;
    private Integer age;
    private String gender;

    public User(){}

    public User(String id, String username, String address, Integer age, String gender) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }
}
