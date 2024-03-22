package cl.thinka.salemicroservice.v1.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "long_desc")
    private String longDesc;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "in_charge")
    private String inCharge;

    @Column(name = "sale_status")
    private String saleStatus;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    private String budget;

    private String price;

    @Column(name = "document_url")
    private String documentUrl;

    private String brief;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "payed_amount")
    private int payedAmount;

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

