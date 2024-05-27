package pr.grifyl;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LetterRepository implements PanacheMongoRepository<Letter> {
}
