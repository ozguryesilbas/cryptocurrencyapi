package hi.cryptocurrencyapi.dataAccess.concretes;

import hi.cryptocurrencyapi.dataAccess.abstracts.CryptocurrencyDao;
import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CryptocurrencyDaoImpl implements CryptocurrencyDao {

    private SessionFactory hibernateFactory;

    @Autowired
    public CryptocurrencyDaoImpl(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("Factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    /**
     * Retrieves cryptocurrency by symbol
     *
     * @return cryptocurrency
     */
    @Override
    @Transactional(readOnly = true)
    public Cryptocurrency getCryptocurrencyBySymbol(String symbol) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cryptocurrency> criteria = builder.createQuery(Cryptocurrency.class);
        Root<Cryptocurrency> root = criteria.from(Cryptocurrency.class);

        criteria.where(builder.equal(root.get("symbol"), symbol));

        criteria.select(root);
        Query<Cryptocurrency> query = session.createQuery(criteria);
        Cryptocurrency cryptocurrency = query.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return cryptocurrency;
    }

    /**
     * Retrieves all cryptocurrencies as list
     *
     * @return list of cryptocurrency
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cryptocurrency> getAllCryptocurrencies() {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cryptocurrency> criteria = builder.createQuery(Cryptocurrency.class);
        Root<Cryptocurrency> root = criteria.from(Cryptocurrency.class);
        criteria.select(root);
        Query<Cryptocurrency> query = session.createQuery(criteria);
        List<Cryptocurrency> cryptocurrencies = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return cryptocurrencies;
    }

    /**
     * Retrieves all historical data for given cryptocurrency
     *
     * @return list of historical data
     */
    @Override
    @Transactional(readOnly = true)
    public List<Historical> getHistoricalData(Cryptocurrency cryptocurrency) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Historical> criteria = builder.createQuery(Historical.class);
        Root<Historical> root = criteria.from(Historical.class);
        builder.equal(root.get("cryptocurrency"), cryptocurrency);
        criteria.select(root);
        Query<Historical> query = session.createQuery(criteria);
        List<Historical> historicalList = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return historicalList;
    }

    /**
     * Saves all cryptocurrencies
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAllCryptocurrencies(List<Cryptocurrency> cryptocurrencies) {

        final Session session = hibernateFactory.openSession();
        session.beginTransaction();

        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            session.saveOrUpdate(cryptocurrency);
        }

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Saves all historical data
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAllHistories(List<Historical> histories) {
        final Session session = hibernateFactory.openSession();
        session.beginTransaction();

        for (Historical historical : histories) {
            session.saveOrUpdate(historical);
        }

        session.getTransaction().commit();
        session.close();
    }
}
