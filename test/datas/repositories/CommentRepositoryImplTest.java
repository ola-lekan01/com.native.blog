package datas.repositories;

import datas.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    private CommentRepository commentRepository;
    private Comment comment1;
    private Comment comment2;


    @BeforeEach
    public void setUp(){
        commentRepository = new CommentRepositoryImpl();

        comment1 = new Comment();
        comment1.setCommenterName("James");
        comment1.setComment("James Comment");

        comment2 = new Comment();
        comment2.setCommenterName("Lakes");
        comment2.setComment("Lakes Comment");
    }

    @Test
    @DisplayName("Test That Comment Can be saved in the comment repository")
    void save() {
        var savedComment = commentRepository.save(comment1);
        assertEquals(1, savedComment.getId());
        assertEquals(1L, commentRepository.count());
    }

    @Test
    void testThatCommentCanBeUpdatedAndCommentIdRemainsTheSame(){
        String commentersName = "Updated Jame's Commenter Name";
        var savedComment1 = commentRepository.save(comment1);

        comment1.setId(1);
        comment1.setCommenterName(commentersName);
        comment1.setComment("Updated Jame's Comment");

        commentRepository.save(comment1);
        assertEquals(1, commentRepository.viewComment(1).getId());
        assertEquals(commentersName, commentRepository.viewComment(1).getCommenterName());
    }

    @Test
    public void testThatCommentByIdReturnsAComment(){
        var savedComment1 = commentRepository.save(comment1);
        var savedComment2 = commentRepository.save(comment2);
        assertEquals(2L, commentRepository.count());
        assertEquals(savedComment1, commentRepository.viewComment(1));
    }

    @Test
    public void testThatAllCommentSavedReturns(){
        var savedComment1 = commentRepository.save(comment1);
        var savedComment2 = commentRepository.save(comment2);
        List<Comment> foundComments = Arrays.asList(savedComment1, savedComment2);
        assertIterableEquals(foundComments, commentRepository.viewComments());
    }


    @Test
    void deleteComment() {
        String commentersName = "Lakes";
        var savedComment1 = commentRepository.save(comment1);
        var savedComment2 = commentRepository.save(comment2);
        assertEquals(2L, commentRepository.count());
        commentRepository.deleteComment(savedComment1);
        assertEquals(1L, commentRepository.count());
        assertNotNull(commentRepository.viewComment(2));
        assertEquals(commentersName, commentRepository.viewComment(2).getCommenterName());
    }

    @Test
    void testDeleteCommentById() {
        String commentersName = "Lakes";
        var savedComment1 = commentRepository.save(comment1);

        assertEquals(1L, commentRepository.count());
        commentRepository.deleteComment(savedComment1);
        assertEquals(0L, commentRepository.count());
    }
}