package recipes.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false)
    private String recipeName;
    

    @ManyToOne(targetEntity = User.class)
    private User owner;
    
    @Column(nullable=false)
    private String ingredients;
    
    @Column(nullable=false)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Recipe> favouriteUsers;

    @ManyToOne(targetEntity = Category.class)
    private Category category;
    

}
