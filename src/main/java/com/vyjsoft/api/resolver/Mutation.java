package com.vyjsoft.api.resolver;


import com.vyjsoft.api.model.Author;
import com.vyjsoft.api.model.Tutorial;
import com.vyjsoft.api.repository.AuthorRepository;
import com.vyjsoft.api.repository.TutorialRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation {

    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;

    @Autowired
    public Mutation(AuthorRepository repository, TutorialRepository tRepository){
        this.authorRepository = repository;
        this.tutorialRepository = tRepository;
    }

    public Author createAuthor(String nombre, int edad){
        Author author = new Author();
        author.setName(nombre);
        author.setAge(edad);
        authorRepository.save(author);
        return author;
    }

    public Tutorial createTutorial(String titulo, String descripcion, Integer authorID){
        Tutorial libro = new Tutorial();
        libro.setAuthor(new Author(authorID));
        libro.setTitle(titulo);
        libro.setDescription(descripcion);

        tutorialRepository.save(libro);
        return libro;
    }


    public boolean deleteTutorial(Integer id){
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(Integer id, String titulo, String descripcion) throws NotFoundException {
        Optional<Tutorial> optionalTutorial = tutorialRepository.findById(id);

        if(optionalTutorial.isPresent()){
            Tutorial tutorial = optionalTutorial.get();

            if(titulo != null)
                tutorial.setTitle(titulo);
            if(descripcion != null)
                tutorial.setDescription(descripcion);

            tutorialRepository.save(tutorial);

            return tutorial;
        }

        throw new NotFoundException("Not found Tutorial to update!");
    }
}
