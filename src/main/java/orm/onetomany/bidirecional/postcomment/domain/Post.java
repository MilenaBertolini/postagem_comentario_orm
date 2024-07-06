package orm.onetomany.bidirecional.postcomment.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<PostComment>();

    public Post addComment(PostComment postComment){
        comments.add(postComment);
        postComment.setPost(this);
        return this;
    }

    public Post removeComment(PostComment postComment){
        comments.remove(postComment);
        postComment.setPost(null);
        return this;
    }
    
}
