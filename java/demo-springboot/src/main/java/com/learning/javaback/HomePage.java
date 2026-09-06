package com.learning.javaback;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Response {
    public String name;
    public int code;
}

class Post {
    public String title;
    public String content;
}

@RestController
public class HomePage {

@PostMapping("/user")
    public String createUser(@RequestBody Response user) {
        return "Received user: " + user.name;
    }
@PostMapping("/post")
    public String createPost(@RequestBody Post post) {
        return "Post created: " + post.title;
}   
}