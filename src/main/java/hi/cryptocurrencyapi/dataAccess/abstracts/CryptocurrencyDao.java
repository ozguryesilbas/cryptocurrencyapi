package hi.cryptocurrencyapi.dataAccess.abstracts;

import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;

import java.util.List;

public interface CryptocurrencyDao {

    Cryptocurrency getCryptocurrencyBySymbol(String symbol);

    List<Cryptocurrency> getAllCryptocurrencies();

    List<Historical> getHistoricalData(Cryptocurrency cryptocurrency);

    void saveAllCryptocurrencies(List<Cryptocurrency> cryptocurrencies);

    void saveAllHistories(List<Historical> histories);

}
