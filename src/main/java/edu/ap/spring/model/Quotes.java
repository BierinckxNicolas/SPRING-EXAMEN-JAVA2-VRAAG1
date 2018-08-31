package edu.ap.spring.model;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Quotes {
	
	private QuoteRepository repository;
	
	@Autowired
	public void setQuoteRepository(QuoteRepository repository) {
		this.repository = repository;
	}


	public ArrayList<Quote> getQuotesByWord(String quote) {
	    return repository.findByQuote(quote);

    }

	/*public ArrayList<Quote> getAllQuotes() {
		saveQuotes();
		ArrayList<Quote> quotes = repository.findAllQuotes();
		return quotes;

	}*/

	public void saveQuotes() {

		String fileName = "oscar_wilde.txt";


		try(BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			for(String line; (line = br.readLine()) != null; ) {
				Quote newQuote = new Quote(line);
				repository.save(newQuote);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
