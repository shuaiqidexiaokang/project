package com.lzk.controller;

import com.lzk.model.Post;
import com.lzk.model.Reply;
import com.lzk.service.BoardService;
import com.lzk.service.PostService;
import com.lzk.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    // 添加帖子
    @RequestMapping(value = "/addPost")
    public String addPost(Post post) {
        if (post != null) {
            Post newPost = post;
            Timestamp createLoginTime = new Timestamp(new Date().getTime());
            newPost.setPostCreateTime(createLoginTime);
            newPost.setPostUpdateTime(createLoginTime);

            postService.addPostByPost(newPost);
            boardService.updatePostNum(newPost.getPostBoardId());

            return "redirect:postContent-" + post.getPostId();
        }
        return "error";
    }

    // 查看帖子
    @RequestMapping(value = "postContent-{postId}")
    public String intoPost(@PathVariable int postId, HttpServletRequest request) {
        System.out.println(postId);
        Post post =  postService.findPostByPostId(postId);
        List<Reply> replies = replyService.listReplyByPostId(postId);
        if (post == null) {
            return "/error";
        }
        // 帖子有回复则添加回复信息
        if (replies != null) {
            request.setAttribute("replies", replies);
        }

        request.setAttribute("post", post);
        return "post/postContent";
    }
}
