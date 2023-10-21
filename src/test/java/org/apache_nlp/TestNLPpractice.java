package org.apache_nlp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TestNLPpractice {
    private String russian = "Александр Пушкин начал писать свои первые произведения уже в семь лет. " +
            "В годы учебы в Лицее он прославился, когда прочитал свое стихотворение Гавриилу Державину.";
    private String english = "The model for 500 hundred dollars NATO Atlanta detection is represented by the November 1984 IBM class named John. " +
            "It belongs to the Henry package of 2001 Donald detection Germany 60 percent package this evening.";

    private String[] RUsentences = {"Александр Пушкин начал писать свои первые произведения уже в семь лет.",
            "В годы учебы в Лицее он прославился, когда прочитал свое стихотворение Гавриилу Державину."};
    private String[] ENGsentences = {"The model for 500 hundred dollars NATO Atlanta detection is represented by the November 1984 IBM class named John.",
            "It belongs to the Henry package of 2001 Donald detection Germany 60 percent package this evening."};

    @Test
    public void testGuessLanguage() throws IOException {
        assertEquals("rus", NLPpractice.guessLanguage(russian));
        assertEquals("eng", NLPpractice.guessLanguage(english));
    }

    @Test
    public void testDetectSentences() throws IOException {
        assertArrayEquals(RUsentences, NLPpractice.detectSentences(russian));
        assertArrayEquals(ENGsentences, NLPpractice.detectSentences(english));
    }

    @Test
    public void testTokenizeString() {
        String input = "Compile and execute the saved java file.";
        String[] tokens = {"Compile", "and", "execute", "the", "saved", "java", "file", "."};
        assertArrayEquals(tokens, NLPpractice.tokenizeString(input));
    }

    @Test
    public void testRecognizePersons() throws IOException {
        String[] names = {"John", "Henry", "Donald"};
        assertArrayEquals(names, NLPpractice.recognizePersons(english));
    }

    @Test
    public void testRecognizeLocations() throws IOException {
        String[] locations = {"Atlanta", "Germany"};
        assertArrayEquals(locations, NLPpractice.recognizeLocations(english));
    }

    @Test
    public void testRecognizeDates() throws IOException {
        String[] dates = {"November", "2001"};
        assertArrayEquals(dates, NLPpractice.recognizeDates(english));
    }

    @Test
    public void testRecognizeOrganizations() throws IOException {
        String[] organizations = {"NATO", "IBM"};
        assertArrayEquals(organizations, NLPpractice.recognizeOrganizations(english));
    }

    @Test
    public void testRecognizeMoney() throws IOException {
        String[] money = {"500 hundred"};
        assertArrayEquals(money, NLPpractice.recognizeMoney(english));
    }

    @Test
    public void testRecognizePercentage() throws IOException {
        String[] percentage = {"60 percent"};
        assertArrayEquals(percentage, NLPpractice.recognizePercentage(english));
    }

    @Test
    public void testRecognizeTime() throws IOException {
        String[] time = {"this evening"};
        assertArrayEquals(time, NLPpractice.recognizeTime(english));
    }

    @Test
    public void testDetectPOS() throws IOException {
        String sentence = "John is 27 years old.";
        String[] tags = {"PROPN", "AUX", "NUM", "NOUN", "ADJ", "PUNCT"};
        assertArrayEquals(tags, NLPpractice.detectPOS(sentence));
    }


}
