package datas.repositories;

import datas.models.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
    private final List<Post> postDatabase = new ArrayList<>();
    private int count;

    @Override
    public Post save(Post post) {
        if(post.getId() != 0) update(post);
        else {
            post.setId(++count);
            postDatabase.add(post);
        }
        return post;
    }

    private void update(Post post) {
        Post savedPost = findById(post.getId());
        savedPost.setTitle(post.getTitle());
        savedPost.setBody(post.getBody());
    }

    @Override
    public Post findById(int id) {
        return postDatabase
                .stream()
                .filter((post)->post.getId() == id).findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Post Id Does not exist"));
    }

    @Override
    public List<Post> findAll() {
        return postDatabase;
    }

    @Override
    public long count() {
        return postDatabase.size();
    }

    @Override
    public void delete(Post post) {
        postDatabase.remove(post);
    }

    @Override
    public void delete(int id) {
        var foundPost = postDatabase
                .stream()
                .filter((post -> post.getId() == id))
                .findFirst()
                .get();
        delete(foundPost);
    }

}
