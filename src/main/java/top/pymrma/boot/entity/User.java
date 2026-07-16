package top.pymrma.boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    private String avatarUrl;
    @Column(nullable = false, unique = true)
    private String email;
    private String bio;
    private String hobbies;
    private String preferences;
    private String status;
    @CreationTimestamp
    private LocalDateTime createAt;
}
