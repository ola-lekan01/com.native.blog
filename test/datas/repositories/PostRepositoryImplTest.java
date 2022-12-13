package datas.repositories;

import datas.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    private PostRepository postRepository;
    private Post post2;
    private Post post;
    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
        post2 = new Post();
        post = new Post();
    }

    @Test
    void save() {
        Post post = new Post();
        post.setTitle("Semicolon Interns Tittle of the post");
        post.setBody("Semicolon Interns Body of the Post");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
    }

    @Test
    void findById() {
        Post post = new Post();
        post.setTitle("Semicolon Interns Tittle of the post");
        post.setBody("Semicolon Interns Body of the Post");
        var savedPost = postRepository.save(post);
        assertEquals(1L, postRepository.count());
        Post foundPost = postRepository.findById(1);
        assertEquals(savedPost, foundPost);

        Post post2 = new Post();
        post.setTitle("Semicolon Interns Tittle of the post 2");
        post.setBody("Semicolon Interns Body of the Post 2");
        var savedPost2 = postRepository.save(post2);
        assertEquals(2L, postRepository.count());

        var foundPost2 = postRepository.findById(2);
        assertEquals(savedPost2, foundPost2);
    }

    @Test
    public void saveNewPostUpdatePostCountIsOneTest(){
        Post post = new Post();
        post.setTitle("Semicolon Interns Tittle of the post");
        post.setBody("Semicolon Interns Body of the Post");
        var savedPost = postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("Updated Body");
        updatedPost.setTitle("Updated Title");
        postRepository.save(updatedPost);

        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
    }

    @Test
    void testThatPostIdIncrementAfterAPostHasBeenDeleted() {
        post = new Post();
        post.setTitle("Title Post 1");
        post.setBody("Body Post 1");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        assertEquals(1, postRepository.findById(1).getId());

        post2 = new Post();
        post2.setTitle("Title Post 2");
        post2.setBody("Body Post 2");
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());
        assertEquals(2, postRepository.findById(2).getId());

        postRepository.delete(post);
        assertEquals(1L, postRepository.count());

        Post post3 = new Post();
        post3.setTitle("Title Post 3");
        post3.setBody("Body Post 3");
        postRepository.save(post3);
        assertEquals(3, postRepository.findById(3).getId());


        Post post4 = new Post();
        post4.setTitle("Title Post 4");
        post4.setBody("Body Post 4");
        postRepository.save(post4);
        assertEquals(4, postRepository.findById(4).getId());


    }

    @Test
    void delete() {
        post = new Post();
        post.setTitle("Title Post 1");
        post.setBody("Body Post 1");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        assertEquals("Title Post 1", post.getTitle());

        post2 = new Post();
        post2.setTitle("Title Post 2");
        post2.setBody("Body Post 2");
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());

        postRepository.delete(post);
        assertEquals(1L, postRepository.count());

        var foundPost2 = postRepository.findById(2);
        assertNotNull(postRepository.findById(2));
        assertEquals("Body Post 2", foundPost2.getBody());

        postRepository.delete(2);
        assertEquals(0L, postRepository.count());
    }
}