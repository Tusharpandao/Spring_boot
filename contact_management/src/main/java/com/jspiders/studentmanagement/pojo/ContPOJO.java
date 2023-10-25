package com.jspiders.studentmanagement.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Data
@Entity
public class ContPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Lob
    private Byte[] photo;
    private Long mobile;

    private String email;

    private String companyName;

    private String title;

    private String groupName;

}
