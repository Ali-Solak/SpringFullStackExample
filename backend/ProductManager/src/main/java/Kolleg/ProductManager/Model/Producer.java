package Kolleg.ProductManager.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "producer")
@Table(name = "producer")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull
    @Size(min = 2, message = "mindestens 2 Zeichen lang.")
    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "producer",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @Access(AccessType.PROPERTY)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private Set<Product> products = new HashSet<>();


    public Producer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

}
