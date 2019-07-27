package pl.sda.securityDemo.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.content like %:content%")
    public List<Post> searchContaining(@Param("content") String content);
}
