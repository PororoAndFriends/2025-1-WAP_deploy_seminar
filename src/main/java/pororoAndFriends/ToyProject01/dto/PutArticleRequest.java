package pororoAndFriends.ToyProject01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PutArticleRequest {
    private String title;
    private String content;
    private Long id;
}
