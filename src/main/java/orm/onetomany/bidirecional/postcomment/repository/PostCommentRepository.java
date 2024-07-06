package orm.onetomany.bidirecional.postcomment.repository;

import org.springframework.data.repository.CrudRepository;

import orm.onetomany.bidirecional.postcomment.domain.PostComment;

public interface PostCommentRepository extends CrudRepository<PostComment, Long>{
    
}
