package hi.cryptocurrencyapi.api.controllers;

import hi.cryptocurrencyapi.business.abstracts.CryptocurrencyService;
import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;
import hi.cryptocurrencyapi.mock.MockDataGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cryptocurrency")
@ApiOperation("Cryptocurrency API")
public class CryptocurrencyController {

    private CryptocurrencyService cryptocurrencyService;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    /**
     * Retrieves all cryptocurrencies
     *
     * @return all cryptocurrencies as response entity
     */
    @ApiOperation(value = "Get all Cryptocurrencies", notes = "Returns all Cryptocurrencies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - Cryptocurrencies not found")
    })
    @GetMapping("/getAllCryptocurrencies")
    public ResponseEntity<?> getAllCryptocurrencies() {

        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.getAllCryptocurrencies();

        if(cryptocurrencies != null){
            return new ResponseEntity<>(cryptocurrencies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Retrieves all historical data for given symbol
     *
     * @return historical data as response entity
     */
    @ApiOperation(value = "Get all historical data by cryptocurrency", notes = "Returns all historical data by cryptocurrency")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - Historical data not found")
    })
    @GetMapping("/getAllHistoricalData/{symbol}")
    public ResponseEntity<?> getAllHistoricalData(@PathVariable("symbol") @ApiParam(name = "symbol", value = "Cryptocurrency symbol", example = "BTCUSD") String symbol) {

        Cryptocurrency cryptocurrency;

        try {
            cryptocurrency = cryptocurrencyService.getCryptocurrencyBySymbol(symbol);
            if (cryptocurrency != null) {
                return new ResponseEntity<>(cryptocurrencyService.getHistoricalData(cryptocurrency), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Generates all cryptocurrencies and historical data
     *
     * @return message as response entity
     */
    @ApiOperation(value = "Generates all cryptocurrencies and historical data", notes = "Generates all cryptocurrencies and historical data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generated"),
            @ApiResponse(code = 400, message = "Not generated - Historical data con not be generated")
    })
    @PostMapping("/generateCryptocurrencies")
    public ResponseEntity<?> generateCryptocurrencies() {
        try {
            List<Cryptocurrency> cryptocurrencies = MockDataGenerator.generateCryptocurrencies();
            List<Historical> historicals = MockDataGenerator.generateHistoricals();
            historicals.stream().forEach(h -> {
                h.setCryptocurrency(cryptocurrencies.get(0));
            });
            cryptocurrencyService.saveAllCryptocurrencies(cryptocurrencies);
            cryptocurrencyService.saveAllHistories(historicals);
            return new ResponseEntity<>("Cryptocurrencies saved successfully...", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Exception occurred while saving Cryptocurrencies... ", HttpStatus.BAD_REQUEST);
        }
    }
}
