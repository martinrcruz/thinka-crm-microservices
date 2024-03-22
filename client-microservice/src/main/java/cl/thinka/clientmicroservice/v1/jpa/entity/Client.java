package cl.thinka.clientmicroservice.v1.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String rut;

    private String email;

    private String city;

    private String contactPlatform;

    private int budget;

    private String projectDescription;

    private LocalDateTime expectedDate;

    private String deliveryStatus;

    private String workLine;

    private String inCharge;

    @CreationTimestamp
    @Column(name = "created_at", updatable=false)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private Long deletedBy;

    private Integer status;

}

