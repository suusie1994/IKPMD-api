package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import javax.persistence.*;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Counter")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id", nullable = false)
    @JsonProperty
    @JsonView(View.Public.class)
    private int id;
    
    @Basic
    @Column(name = "clicked", nullable = false)
    @Length(min = 1, max = 255)
    @JsonProperty
    @JsonView(View.Public.class)
    private String clicked;
}
