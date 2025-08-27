package com.example.blog_dos_devs.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "blog_user")
@Data
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<post> posts;

    @OneToMany(mappedBy = "user")
    private List<comment> comments;
}
