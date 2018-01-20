package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import javax.persistence.*;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Pagina")
public class Pagina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty
    @JsonView(View.Public.class)
    private int id;
    
    @Basic
    @Column(name = "name", nullable = false)
    @Length(min = 1, max = 255)
    @JsonProperty
    @JsonView(View.Public.class)
    private String name;
    
    @Basic
    @Column(name = "opend", nullable = false)
    @JsonProperty
    @JsonView(View.Public.class)
    private int opend;
}
