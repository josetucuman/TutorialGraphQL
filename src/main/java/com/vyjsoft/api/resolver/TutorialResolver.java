package com.vyjsoft.api.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vyjsoft.api.model.Author;
import com.vyjsoft.api.model.Tutorial;
import com.vyjsoft.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorialResolver implements GraphQLResolver<Tutorial> {

    @Autowired
    private AuthorRepository repository;

    public TutorialResolver(AuthorRepository repository){
        this.repository = repository;
    }

    public Author getAuthor(Tutorial tutorial){
        return repository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}
