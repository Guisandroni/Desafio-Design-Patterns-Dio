package dev.guisandroni.Design_patterns_dio.service;


import dev.guisandroni.Design_patterns_dio.model.Tutor;
import dev.guisandroni.Design_patterns_dio.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id);
    }

    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor update(Long id, Tutor updatedTutor) {
        return tutorRepository.findById(id)
                .map(tutor -> {
                    tutor.setName(updatedTutor.getName());
                    tutor.setAnimal(updatedTutor.getAnimal());

                    return tutorRepository.save(tutor);
                })
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com ID: " + id));
    }

    public void deleteById(Long id) {
        tutorRepository.deleteById(id);
    }
}
