package hi.cryptocurrencyapi.business.concretes;

import hi.cryptocurrencyapi.business.abstracts.CryptocurrencyService;
import hi.cryptocurrencyapi.dataAccess.abstracts.CryptocurrencyDao;
import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    private CryptocurrencyDao cryptocurrencyDao;

    @Autowired
    public CryptocurrencyServiceImpl(CryptocurrencyDao cryptocurrencyDao) {
        this.cryptocurrencyDao = cryptocurrencyDao;
    }

    /**
     * Retrieves cryptocurrency by symbol
     *
     * @return cryptocurrency
     */
    @Override
    public Cryptocurrency getCryptocurrencyBySymbol(String symbol) {
        return cryptocurrencyDao.getCryptocurrencyBySymbol(symbol);
    }

    /**
     * Retrieves all cryptocurrencies as list
     *
     * @return list of cryptocurrency
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyDao.getAllCryptocurrencies();
    }

    /**
     * Retrieves all historical data for given cryptocurrency
     *
     * @return list of historical data
     */
    @Override
    @Transactional(readOnly = true)
    public List<Historical> getHistoricalData(Cryptocurrency cryptocurrency) {
        return cryptocurrencyDao.getHistoricalData(cryptocurrency);
    }

    /**
     * Saves all cryptocurrencies
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAllCryptocurrencies(List<Cryptocurrency> cryptocurrencies) {
        cryptocurrencyDao.saveAllCryptocurrencies(cryptocurrencies);
    }

    /**
     * Saves all historical data
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAllHistories(List<Historical> histories) {
        cryptocurrencyDao.saveAllHistories(histories);
    }

}
