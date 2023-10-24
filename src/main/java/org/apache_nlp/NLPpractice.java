package org.apache_nlp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceDetectorME;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;

public class NLPpractice {
    public static String guessLanguage(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/langdetect-183.bin")){
            LanguageDetectorModel langModel = new LanguageDetectorModel(is);
            LanguageDetector langDetect = new LanguageDetectorME(langModel);
            return langDetect.predictLanguage(input).getLang();
        }
    }

    public static String[] detectSentences(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin")){
            SentenceModel sentModel = new SentenceModel(is);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentModel);
            return sentenceDetector.sentDetect(input);
        }
    }

    public static String[] tokenizeString(String input){
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        return tokenizer.tokenize(input);
    }

    public static String[] recognizeDates(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-date.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);
            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] recognizePersons(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-person.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] recognizeLocations(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-location.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] recognizeOrganizations(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-organization.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] recognizeMoney(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-money.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] recognizePercentage(String input) throws IOException{
        try(InputStream is = NLPpractice.class.getResourceAsStream("/en-ner-percentage.bin")){
            TokenNameFinderModel model = new TokenNameFinderModel(is);
            NameFinderME nameFinder = new NameFinderME(model);

            String[] tInput = NLPpractice.tokenizeString(input);
            Span[] nameSpans = nameFinder.find(tInput);
            return Span.spansToStrings(nameSpans, tInput);
        }
    }

    public static String[] detectPOS(String input){
        //Для работы данного метода нужно заменить путь к проекту в начале pathname ниже
        POSModel model = new POSModelLoader().load(new File("C:\\Users\\zxc\\Documents\\ApacheNLPPractice\\src\\main\\resources\\en-pos-maxent.bin"));
        POSTaggerME tagger = new POSTaggerME(model);
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(input);
        String[] tags = tagger.tag(tokens);
        return tags;
    }
}
