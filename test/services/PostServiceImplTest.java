package services;

import datas.dtos.requests.CreatePost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    private PostService postService;

    @BeforeEach
    void setUp(){
        postService = new PostServiceImpl();
    }

    @Test
    void createPost() {
        CreatePost createPost = new CreatePost();
        createPost.setTitle("The Post Title");
        createPost.setBody("The Post Body");
        postService.createPost(createPost);
        assertEquals(1, postService.viewAllPosts().size());
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void viewAllPosts() {
    }
}