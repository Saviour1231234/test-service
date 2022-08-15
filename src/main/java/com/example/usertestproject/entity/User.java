package com.example.usertestproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document("User")
@Data
@AllArgsConstructor
public class User {
    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    public User() {
        this.id = new ObjectId().toString();
    }
}
