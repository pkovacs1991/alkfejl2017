package recipes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    @Column(nullable=false, unique = true)
    private String email;

    private String password;

    @OneToMany(targetEntity = Recipe.class, mappedBy = "owner")
    private List<Recipe> recipes;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "favouriteUsers")
    private Set<Recipe> favoriteRecipes;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        GUEST, USER, ADMIN
    }
}