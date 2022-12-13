package datas.repositories;

import datas.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{

    List<Comment> commentDatabase = new ArrayList<>();
    private int count;

    @Override
    public Comment save(Comment comment) {
        if(comment.getId() != 0) updateComment(comment);
        else {
            comment.setId(++count);
            commentDatabase.add(comment);
        }
        return comment;
    }

    private void updateComment(Comment comment) {
        comment.setId(comment.getId());
        comment.setCommenterName(comment.getCommenterName());
        comment.setComment(comment.getComment());
    }

    @Override
    public List<Comment> viewComments() {
        return commentDatabase;
    }

    @Override
    public Comment viewComment(int id) {
        return commentDatabase.stream()
        .filter(comment -> comment.getId() == id)
        .findFirst().get();
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDatabase.remove(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        var foundComment = commentDatabase
                .stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst().get();
        commentDatabase.remove(foundComment);

    }

    @Override
    public long count() {
        return commentDatabase.size();
    }
}
