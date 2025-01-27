package sa.whitehelmet.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "plot")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PlotStatus status;
    @Column(name = "irrigation_period_in_hours")
    private Integer irrigationPeriodInHours;
    @Column(name = "amount_of_water")
    private Integer waterAmount;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;
    @Column(name = "irrigated_at")
    @CreationTimestamp
    private ZonedDateTime irrigatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlotStatus getStatus() {
        return status;
    }

    public void setStatus(PlotStatus status) {
        this.status = status;
    }

    public Integer getIrrigationPeriodInHours() {
        return irrigationPeriodInHours;
    }

    public void setIrrigationPeriodInHours(Integer irrigationPeriodInHours) {
        this.irrigationPeriodInHours = irrigationPeriodInHours;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getIrrigatedAt() {
        return irrigatedAt;
    }

    public void setIrrigatedAt(ZonedDateTime irrigatedAt) {
        this.irrigatedAt = irrigatedAt;
    }

    public Integer getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Integer waterAmount) {
        this.waterAmount = waterAmount;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", irrigationPeriodInHours=" + irrigationPeriodInHours +
                ", waterAmount=" + waterAmount +
                ", createdAt=" + createdAt +
                ", irrigatedAt=" + irrigatedAt +
                '}';
    }
}
