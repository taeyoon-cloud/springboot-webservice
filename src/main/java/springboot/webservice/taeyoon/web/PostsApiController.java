package springboot.webservice.taeyoon.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.webservice.taeyoon.service.posts.PostsService;
import springboot.webservice.taeyoon.web.dto.PostsResponseDto;
import springboot.webservice.taeyoon.web.dto.PostsSaveRequestDto;
import springboot.webservice.taeyoon.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController // 컨트롤러를 JOSN을 반환하는 컨트롤러로 만들어준다. p.60
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findByID(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
