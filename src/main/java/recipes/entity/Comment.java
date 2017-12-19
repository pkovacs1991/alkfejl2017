package recipes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(targetEntity = User.class)
    @JsonIgnoreProperties("comments")
    private User user;
    
    @ManyToOne(targetEntity = Recipe.class)
    private Recipe recipe;
    
    @Column(nullable=false)
    private String comment;
    
}
