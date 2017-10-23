package recipes.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false)
    private String recipename;
    
    @Column(nullable=false)
    private String username;
    
    @Column(nullable=false)
    private String ingredients;
    
    @Column(nullable=false)
    private String description;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    
    public enum Category {
        SOUP, PIZZA, PASTA
    }
}
