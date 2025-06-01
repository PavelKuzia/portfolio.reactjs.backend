package movie_trending.backend.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import movie_trending.backend.dao.TrendRepository;
import movie_trending.backend.model.TrendingMovies;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UpdateTrendingController {
    private final TrendRepository trendRepository;

    @GetMapping("trends")
    private List<TrendingMovies> getAll() {
        return trendRepository.findAll();
    }

    @GetMapping("trends/query")
    private List<TrendingMovies> findByQuery(@RequestParam String searchTerm) {
        return trendRepository.findBySearchTermContains(searchTerm);
    }

    @PostMapping("/trends")
    @ResponseStatus(HttpStatus.CREATED)
    private String addNewTrend(@RequestBody TrendingMovies trendingMovie) {
        trendRepository.save(trendingMovie);
        return "new entry created";
    }

    @PutMapping("/trends/{id}")
    public ResponseEntity<TrendingMovies> updateCount(@PathVariable Long id) {
        Optional<TrendingMovies> movieOpt = trendRepository.findById(id);
        if (movieOpt.isPresent()) {
            TrendingMovies movie = movieOpt.get();
            Integer count = movie.getCount();
            movie.setCount(movie.getCount() + 1);
            trendRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/trends/top10")
    public List<TrendingMovies> getTenTrendMovies() {
        return trendRepository.findTop10ByOrderByCountDesc();
    }

    @GetMapping("/trends/top5")
    public List<TrendingMovies> getFiveTrendMovies() {
        return trendRepository.findTop5ByOrderByCountDesc();
    }
}
