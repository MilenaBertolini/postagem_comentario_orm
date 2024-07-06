package orm.onetomany.bidirecional.postcomment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.onetomany.bidirecional.postcomment.repository.PostRepository;
import orm.onetomany.bidirecional.postcomment.domain.Post;

@Service
public class PostService {
    
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCommentService postCommentService;

    public List<Post> getAll(){
        try {
            List<Post> posts = new ArrayList<Post>();
            postRepository.findAll().forEach(posts::add);
            
            return posts;
        } catch (Exception e) {
            return null;
        }
    }

    public Post getById(Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){

            return post.get();
        }
        return null;
    }

    public Post create(Post post){
        Post createPost = postRepository.save(post);

        for(int i=0; i<post.getComments().size(); i++){
            postCommentService.create(post.getComments().get(i));
        }

        return createPost;
    }

    public Post update(Long id, Post posts){
        Optional<Post> existingPostOptional = postRepository.findById(id);
        if(existingPostOptional.isPresent()){
            Post existingPost = existingPostOptional.get();
            existingPost.setTittle(posts.getTittle());
            existingPost.setComments(posts.getComments());
            return postRepository.save(existingPost);
        }
        return null;
    }

    public boolean delete(Long id){
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

