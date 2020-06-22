package nl.budroid.netlogapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NetlogController {

    /**
     * Retrieve something
     *
     * @return String
     */
    @GetMapping
    public String getWoefha() {
        return "Woefha!";
    }
}
