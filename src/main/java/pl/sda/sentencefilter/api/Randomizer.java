package pl.sda.sentencefilter.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("randomizig-machine")
public interface Randomizer {
    @GetMapping("/word")
    public String randomWord();

    @GetMapping("/number")
    public String randomNumber();
}
