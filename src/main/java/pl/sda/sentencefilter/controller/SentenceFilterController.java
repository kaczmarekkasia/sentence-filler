package pl.sda.sentencefilter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.sentencefilter.api.Randomizer;

@RestController
public class SentenceFilterController {
//    localhost:8061/fill?sentence=Siema jestem @@@ i mam !!! lat a ona jest @@@ i ma !!! lat!
    @Autowired
    private Randomizer randomizer;

    @GetMapping("/fill")
    public String fill(@RequestParam(name = "sentence", required = false) String sentence){
        if (sentence != null){
            while (sentence.contains("!!!")){
                sentence = sentence.replaceFirst("!!!", getRandomNumber());
            }
            while (sentence.contains("@@@")) {
                sentence = sentence.replaceFirst("@@@", getRandomWord());
            }
            return sentence; /*sentence po zmianie*/
        }
        return "Proszę o podanie zdania do wypełnienia";
    }

    private String getRandomWord() {
        return randomizer.randomWord();
    }

    private String getRandomNumber() {
        return randomizer.randomNumber();
    }
}
