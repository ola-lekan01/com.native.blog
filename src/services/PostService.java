package services;

import datas.dtos.requests.CreatePost;
import datas.models.Post;

import java.util.List;

public interface PostService {
    void createPost(CreatePost createPost);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    List<Post> viewAllPosts();
}
