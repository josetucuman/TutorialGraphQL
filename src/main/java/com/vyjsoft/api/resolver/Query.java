package com.vyjsoft.api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vyjsoft.api.model.Author;
import com.vyjsoft.api.model.Tutorial;
import com.vyjsoft.api.repository.AuthorRepository;
import com.vyjsoft.api.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Query implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    private TutorialRepository tutorialRepository;

    @Autowired
    public Query(AuthorRepository repository, TutorialRepository tRepository){
        this.authorRepository = repository;
        this.tutorialRepository = tRepository;
    }

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials(){
        return tutorialRepository.findAll();
    }

    public long countAuthors(){
        return authorRepository.count();
    }

    public long countTutorials(){
        return tutorialRepository.count();
    }
}
