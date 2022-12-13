package datas.repositories;

import datas.models.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);
    List<Comment> viewComments();
    Comment viewComment(int id);

    void deleteComment(Comment comment);

    void deleteComment(int commentId);

    long count();
}
