package nl.budroid.netlogapi.controller;

import nl.budroid.netlogapi.parser.PcapParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
        String pcapfile = System.getProperty("user.dir") + "/captures/network.pcap";
        System.out.println(pcapfile);

        try {
            PcapParser.parse(pcapfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "DONE";
    }
}
