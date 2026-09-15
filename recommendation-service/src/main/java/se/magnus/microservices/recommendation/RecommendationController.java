package se.magnus.microservices.recommendation;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return service.create(recommendation);
    }

    @GetMapping
    public List<Recommendation> getRecommendations(@RequestParam int productId) {
        return service.findByProductId(productId);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecommendations(@RequestParam int productId) {
        service.deleteByProductId(productId);
        return ResponseEntity.noContent().build();
    }
}
