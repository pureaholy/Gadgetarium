package us.peaksoft.gadgetarium.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.FeedbackRequest;
import us.peaksoft.gadgetarium.dto.FeedbackResponce;
import us.peaksoft.gadgetarium.dto.RatingResponce;
import us.peaksoft.gadgetarium.dto.SimpleResponse;
import us.peaksoft.gadgetarium.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("api/feedbacks")
@Tag(name = "FeedbackController", description = "API endpoints for managing feedbacks")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping
    @Operation(description = "Only admin can see a list of feedbacks")
    public List<FeedbackResponce> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @PostMapping
    @Operation(description = "All users can add a feedback")
    public SimpleResponse save(@RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.save(feedbackRequest);
    }

    @GetMapping("{id}")
    @Operation(description = "Only admin can get feedback by id")
    public FeedbackResponce getById(@PathVariable("id") Long id) {
        return feedbackService.getById(id);
    }

    @PutMapping("{id}")
    @Operation(description = "All users can update a feedback")
    public FeedbackResponce update(@PathVariable("id") Long id, @RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.update(id, feedbackRequest);
    }

    @DeleteMapping("{id}")
    @Operation(description = "All users and admin can delete a feedback")
    public SimpleResponse delete(@PathVariable("id") Long id) {
        return feedbackService.delete(id);
    }

    @PutMapping("/admin/{id}")
    @Operation(description = "Only admin can reply to feedback")
    public FeedbackResponce reply(@PathVariable("id") Long id, @RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.reply(id, feedbackRequest);
    }

    @GetMapping("/rating/{id}")
    @Operation(description = "infographic reviews by product id")
    public RatingResponce rating(@PathVariable("id") Long id) {
        return feedbackService.rating(id);
    }

    @GetMapping("/product/{id}")
    @Operation(description = "All feedbacks by product id")
    public List<FeedbackResponce> getAllFeedbacksByProduct(@PathVariable("id") Long id) {
        return feedbackService.getAllFeedbacksByProductId(id);
    }
}
