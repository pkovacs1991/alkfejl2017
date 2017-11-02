package recipes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;;
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
@EqualsAndHashCode(of = {"id"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Column(nullable=false, unique = true)
    private String email;

    private String password;

    @OneToMany(targetEntity = Recipe.class, mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recipe> recipes;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "favouriteUsers")
    @JsonIgnore
    private Set<Recipe> favoriteRecipes;

    @OneToMany(targetEntity = Comment.class, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        GUEST, USER, ADMIN
    }

}