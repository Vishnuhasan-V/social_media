package com.social_media.mapper;

import com.social_media.dto.CommentDto;
import com.social_media.dto.UserDto;
import com.social_media.dto.LikeDto;
import com.social_media.dto.PostDto;
import com.social_media.entity.Comment;
import com.social_media.entity.User;
import com.social_media.entity.Like;
import com.social_media.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MapStructMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User toUser(UserDto userDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserDto toUserDto(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "postId", target = "post.id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "commentText", target = "commentText")
    Comment toComment(CommentDto commentDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "commentText", target = "commentText")
    CommentDto toCommentDto(Comment comment);
    List<CommentDto> commentListToCommentDtoList(List<Comment> comments);
    List<Comment> commentDtoListToCommentList(List<CommentDto> commentDtos);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "postId", target = "post.id")
    @Mapping(source = "userId", target = "userId")
    Like toLike(LikeDto likeDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "userId", target = "userId")
    LikeDto toLikeDto(Like like);
    List<LikeDto> likeListToLikeDtoList(List<Like> likes);
    List<Like> likeDtoListToLikeList(List<LikeDto> likeDtos);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "comments", target = "comments")
    @Mapping(source = "likes", target = "likes")
    Post toPost(PostDto postDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "comments", target = "comments")
    @Mapping(source = "likes", target = "likes")
    PostDto toPostDto(Post post);
    List<PostDto> postListToPostDtoList(List<Post> likes);
    List<Post> postDtoListToPostList(List<PostDto> likeDtos);
}
