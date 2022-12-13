package services;

import datas.dtos.requests.CreatePost;
import datas.models.Post;
import datas.repositories.PostRepository;
import datas.repositories.PostRepositoryImpl;

import java.util.List;

public class PostServiceImpl implements PostService{

    private final PostRepository postRepository = new PostRepositoryImpl();
    @Override
    public void createPost(CreatePost createPost) {
        Post post = new Post();
        post.setTitle(createPost.getTitle());
        post.setBody(createPost.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public List<Post> viewAllPosts() {
        return postRepository.findAll();
    }
}
