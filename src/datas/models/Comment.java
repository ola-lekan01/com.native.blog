package datas.models;

public class Comment {
    private String commenterName;
    private int commentId;
    private  String comment;;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public int getId() {
        return commentId;
    }

    public void setId(int commentId) {
        this.commentId = commentId;
    }
}
