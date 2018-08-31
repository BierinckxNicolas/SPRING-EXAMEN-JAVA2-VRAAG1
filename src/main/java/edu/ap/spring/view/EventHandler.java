package edu.ap.spring.view;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.model.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nicolas on 31/08/2018.
 */
    @Service
    public class EventHandler {

        private UI ui;
        private Quotes quotes;

        @Autowired
        public void setUI(UI ui) {
            this.ui = ui;
        }

        @Autowired
        public void setQuotes(Quotes quotes) {
            this.quotes = quotes;
        }

        public void whenButtonClicked(ActionEvent actionEvent) {
            quotes.saveQuotes();
    }

    public void whenButton1Clicked(ActionEvent actionEvent) {
           // String quote = ui.getQuote().getText();
          //  ui.getAnswerLabel().setText(String.valueOf(quotes.getQuotesByWord(quote)));
        Long quote = Long.valueOf(ui.getQuote().getText());
        ui.getAnswerLabel().setText(String.valueOf(quotes.getQuoteById(quote)));

    }
    
        }







