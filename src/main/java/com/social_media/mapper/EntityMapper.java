package com.social_media.mapper;

import com.social_media.dto.CommentDto;
import com.social_media.dto.UserDto;
import com.social_media.dto.LikeDto;
import com.social_media.dto.PostDto;
import com.social_media.entity.Comment;
import com.social_media.entity.User;
import com.social_media.entity.Like;
import com.social_media.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface EntityMapper {

    User toUser(UserDto userDto);
    UserDto toUserDto(User user);

    Comment toComment(CommentDto commentDto);
    CommentDto toCommentDto(Comment comment);

    Like toLike(LikeDto likeDto);
    LikeDto toLikeDto(Like like);

    Post toPost(PostDto postDto);
    PostDto toPostDto(Post post);
}
