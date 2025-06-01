package movie_trending.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "t_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrendingMovies {
    @Id
    private Long movieId;
    private Integer count;
    private String searchTerm;
    private String posterUrl;
}
