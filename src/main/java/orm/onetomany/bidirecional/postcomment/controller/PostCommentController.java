package orm.onetomany.bidirecional.postcomment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orm.onetomany.bidirecional.postcomment.domain.PostComment;
import orm.onetomany.bidirecional.postcomment.service.PostCommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/postComments")
public class PostCommentController {
    
    @Autowired
    PostCommentService postCommentService;

    @GetMapping
    public List<PostComment> getAll(){

        List<PostComment> comments = postCommentService.getAll();
        return comments;
    }

    @GetMapping("{id}")
    public PostComment getById(@PathVariable("id") Long id){
        return postCommentService.getById(id);
    }

    @PostMapping
    public PostComment create(@RequestBody PostComment postComment){
        PostComment comments = postCommentService.create(postComment);
        return comments;
    }

    @PutMapping("{id}")
    public PostComment updatePost(@PathVariable("id") Long id, @RequestBody PostComment postComment){
        return postCommentService.update(id, postComment);
    }  

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return postCommentService.delete(id);
    }

    
    
}
