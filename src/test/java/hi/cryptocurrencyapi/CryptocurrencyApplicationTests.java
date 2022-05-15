package hi.cryptocurrencyapi;

import hi.cryptocurrencyapi.business.abstracts.CryptocurrencyService;
import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;
import hi.cryptocurrencyapi.mock.MockDataGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CryptocurrencyApplicationTests {

    private CryptocurrencyService cryptocurrencyService;

    @Autowired
    public CryptocurrencyApplicationTests(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @Test
    void generateCryptocurrencyData() {
        List<Cryptocurrency> cryptocurrencies = MockDataGenerator.generateCryptocurrencies();
        List<Historical> historicals = MockDataGenerator.generateHistoricals();
        historicals.stream().forEach(h -> {
            h.setCryptocurrency(cryptocurrencies.get(0));
        });
        cryptocurrencyService.saveAllCryptocurrencies(cryptocurrencies);
        cryptocurrencyService.saveAllHistories(historicals);

        Assert.assertEquals(cryptocurrencyService.getAllCryptocurrencies().size(), 3);
    }

    @Test
    void getHistoricalDataBySymbol() {
        Cryptocurrency cryptocurrency = cryptocurrencyService.getCryptocurrencyBySymbol("BTCUSD");
        Assert.assertNotNull(cryptocurrency);

        List<Historical> historicalList = cryptocurrencyService.getHistoricalData(cryptocurrency);
        Assert.assertEquals(historicalList.size(), 3);
    }


}
