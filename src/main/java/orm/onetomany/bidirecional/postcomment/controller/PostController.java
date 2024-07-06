package orm.onetomany.bidirecional.postcomment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orm.onetomany.bidirecional.postcomment.domain.Post;
import orm.onetomany.bidirecional.postcomment.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAll(){

        List<Post> posts = postService.getAll();
        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable("id") Long id){
        return postService.getById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post postComment){
        Post post = postService.create(postComment);
        return post;
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post postComment){
        return postService.update(id, postComment);
    }  

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return postService.delete(id);
    }
    


    
    
}
