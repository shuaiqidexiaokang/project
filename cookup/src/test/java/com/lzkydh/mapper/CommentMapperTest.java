package com.lzkydh.mapper;

import com.lzkydh.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void addComment() throws Exception {
        // Comment(int recipeId, int userId, int score, String content)
        Comment comment = new Comment(1000,1001,2,"1234");
        int count = commentMapper.addComment(comment);
        System.out.println(count);
    }

    @Test
    public void deleteCommentByUserIdAndRecipeId() throws Exception {
        int count = commentMapper.deleteCommentByUserIdAndRecipeId(1000,1000);
        System.out.println(count);
    }

    @Test
    public void queryByRecipeIdWithUser() throws Exception {
        List<Comment> comments = commentMapper.queryByRecipeIdWithUser(1000);
        comments.forEach(System.out::println);
    }

    @Test
    public void queryByUserIdWithRecipe() throws Exception {
        List<Comment> comments = commentMapper.queryByUserIdWithRecipe(1001);
        comments.forEach(System.out::println);
    }

}