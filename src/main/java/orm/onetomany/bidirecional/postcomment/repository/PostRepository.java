package orm.onetomany.bidirecional.postcomment.repository;

import org.springframework.data.repository.CrudRepository;

import orm.onetomany.bidirecional.postcomment.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
    
}
