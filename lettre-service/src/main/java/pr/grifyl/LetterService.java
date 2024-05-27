package pr.grifyl;

import java.util.List;

import org.bson.types.ObjectId;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LetterService {

    @Inject
    LetterRepository letterRepository;

    public Letter createLetter(Letter letter) {
        letter.setStatus("postée");
        letterRepository.persist(letter);
        return letter;
    }

    public Letter findById(String id) {
        return letterRepository.findById(new ObjectId(id));
    }

    public List<Letter> findAll() {
        return letterRepository.listAll();
    }

    public void updateStatus(String id, String status) {
        Letter letter = letterRepository.findById(new ObjectId(id));
        if (letter != null) {
            letter.setStatus(status);
            letterRepository.update(letter);
        }
    }
}
