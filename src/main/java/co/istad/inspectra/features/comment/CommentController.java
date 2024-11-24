package co.istad.inspectra.features.comment;

import co.istad.inspectra.base.BaseRestResponse;
import co.istad.inspectra.features.comment.dto.CommentRequest;
import co.istad.inspectra.features.comment.dto.CommentResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "Create a comment")
    @PostMapping
    public BaseRestResponse<CommentResponse> createComment(@Valid @RequestBody CommentRequest commentRequest)
    {
        return BaseRestResponse.<CommentResponse>
                builder()
                .data(commentService.createComment(commentRequest))
                .message("Comment created successfully")
                .build();
    }

    @Operation(summary = "Get all comments")
    @GetMapping("/all")
    public BaseRestResponse<List<CommentResponse>> getAllComments()
    {
        return BaseRestResponse.< List<CommentResponse>>
                builder()
                .data(commentService.getAllComments())
                .message("All comments retrieved successfully")
                .build();
    }


    @Operation(summary = "Like a comment")
    @PostMapping("/like/{commentUuid}")
    public BaseRestResponse<String> likeComment(@PathVariable String commentUuid)
    {
        return BaseRestResponse.<String>
                builder()
                .data(commentService.likeComment(commentUuid))
                .message("Comment liked successfully")
                .build();
    }

    @Operation(summary = "Delete like a comment")
    @DeleteMapping("/like/{commentUuid}")
    public BaseRestResponse<String> deleteLikeComment(@PathVariable String commentUuid)
    {
        commentService.deleteLikeComment(commentUuid);
        return BaseRestResponse.<String>
                builder()
                .message("Comment like deleted successfully")
                .build();
    }

    @Operation(summary = "Update a comment")
    @PutMapping("/{uuid}")
    public BaseRestResponse<CommentResponse> updateComment(@PathVariable String uuid, @RequestBody String content)
    {
        return BaseRestResponse.<CommentResponse>
                builder()
                .data(commentService.updateComment(uuid, content))
                .message("Comment updated successfully")
                .build();
    }


    @Operation(summary = "Get comments by blog uuid")
    @GetMapping("/{uuid}")
    public BaseRestResponse<CommentResponse> getCommentsByBlogUuid(@PathVariable String uuid)
    {
        return BaseRestResponse.<CommentResponse>
                builder()
                .data(commentService.getCommentsByBlogUuid(uuid))
                .message("Comments retrieved successfully")
                .build();
    }

    @Operation(summary = "Delete a comment")
    @DeleteMapping("/{uuid}")
    public BaseRestResponse<String> deleteComment(@PathVariable String uuid)
    {
        commentService.deleteComment(uuid);
        return BaseRestResponse.<String>
                builder()
                .message("Comment deleted successfully")
                .build();
    }
}
