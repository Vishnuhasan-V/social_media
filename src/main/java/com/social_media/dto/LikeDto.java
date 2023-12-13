package com.social_media.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private int id;
    private int postId;
    private int userId;
}
