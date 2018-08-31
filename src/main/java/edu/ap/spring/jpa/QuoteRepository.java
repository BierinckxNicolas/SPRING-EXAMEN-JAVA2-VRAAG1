package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

    public ArrayList<Quote> findByQuote(String quote);


   // public ArrayList<Quote> findAllQuotes();

}

