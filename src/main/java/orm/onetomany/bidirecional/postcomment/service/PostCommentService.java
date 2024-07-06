package orm.onetomany.bidirecional.postcomment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.onetomany.bidirecional.postcomment.domain.PostComment;
import orm.onetomany.bidirecional.postcomment.repository.PostCommentRepository;
import orm.onetomany.bidirecional.postcomment.repository.PostRepository;

@Service
public class PostCommentService {

    @Autowired
    PostCommentRepository postCommentRepository;

    @Autowired
    PostRepository postRepository;

    public List<PostComment> getAll(){
        try {
            List<PostComment> comments = new ArrayList<PostComment>();
            postCommentRepository.findAll().forEach(comments::add);
            return comments;
        } catch (Exception e) {
            return null;
        }
    }

    public PostComment getById(Long id){
        Optional<PostComment> comments = postCommentRepository.findById(id);
        if(comments.isPresent()){
            return comments.get();
        }
        return null;
    }

    public PostComment create(PostComment comment){
        return postCommentRepository.save(comment);
    }
    
    public PostComment update(Long id, PostComment comment){
        Optional<PostComment> existingCommentOptional = postCommentRepository.findById(id);
        if(existingCommentOptional.isPresent()){
            PostComment existingComment = existingCommentOptional.get();
            existingComment.setPost(comment.getPost());
            existingComment.setReview(comment.getReview());
            return postCommentRepository.save(existingComment);
        }
        return null;
    }

    public boolean delete(Long id){
        try {
            postCommentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
