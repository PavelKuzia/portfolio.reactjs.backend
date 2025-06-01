package movie_trending.backend.dao;

import movie_trending.backend.model.TrendingMovies;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrendRepository extends JpaRepository<TrendingMovies, Long> {
    List<TrendingMovies> findBySearchTermContains(String searchTerm);
    List<TrendingMovies> findTop10ByOrderByCountDesc();
    List<TrendingMovies> findTop5ByOrderByCountDesc();
}
