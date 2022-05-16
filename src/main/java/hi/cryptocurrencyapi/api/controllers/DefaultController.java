package hi.cryptocurrencyapi.api.controllers;

import hi.cryptocurrencyapi.business.abstracts.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DefaultController {

    private CryptocurrencyService cryptocurrencyService;

    @Autowired
    public DefaultController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCryptocurrencies() {
        return new ResponseEntity<>("Hello EKS", HttpStatus.OK);
    }

}
