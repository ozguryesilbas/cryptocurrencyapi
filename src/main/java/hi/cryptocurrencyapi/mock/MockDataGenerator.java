package hi.cryptocurrencyapi.mock;

import hi.cryptocurrencyapi.entities.Cryptocurrency;
import hi.cryptocurrencyapi.entities.Historical;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockDataGenerator {

    public static List<Cryptocurrency> generateCryptocurrencies() {

        List<Cryptocurrency> cryptocurrencies = new ArrayList<>();

        Cryptocurrency c1 = new Cryptocurrency();
        Cryptocurrency c2 = new Cryptocurrency();
        Cryptocurrency c3 = new Cryptocurrency();

        c1.setSymbol("BTCUSD");
        c1.setPrice(new BigDecimal("0.00462742"));
        c1.setChangesPercentage(new BigDecimal("0E-8"));
        c1.setChange(new BigDecimal("0.00462742"));
        c1.setDayLow(new BigDecimal("0E-8"));
        c1.setDayHigh(new BigDecimal("0E-8"));
        c1.setYearHigh(new BigDecimal("0.01097000"));
        c1.setYearLow(new BigDecimal("0E-8"));
        c1.setMarketCap(new BigDecimal("48541.00000000"));
        c1.setPriceAvg50(new BigDecimal("0E-8"));
        c1.setPriceAvg200(new BigDecimal("0.00318208"));
        c1.setVolume(0);
        c1.setAvgVolume(0);
        c1.setExhange("CRYPTO");

        c2.setSymbol("DCRUSD");
        c2.setPrice(new BigDecimal("18.87349900"));
        c2.setChangesPercentage(new BigDecimal("-5.21000000"));
        c2.setChange(new BigDecimal("-1.03820100"));
        c2.setDayLow(new BigDecimal("18.37211800"));
        c2.setDayHigh(new BigDecimal("20.02625700"));
        c2.setYearHigh(new BigDecimal("39.91658400"));
        c2.setYearLow(new BigDecimal("12.81343000"));
        c2.setMarketCap(new BigDecimal("203585248.00000000"));
        c2.setPriceAvg50(new BigDecimal("19.91170000"));
        c2.setPriceAvg200(new BigDecimal("21.52632900"));
        c2.setVolume(97878960);
        c2.setAvgVolume(15785003);
        c2.setExhange("CRYPTO");

        c3.setSymbol("QASHUSD");
        c3.setPrice(new BigDecimal("0.04980273"));
        c3.setChangesPercentage(new BigDecimal("-6.20000000"));
        c3.setChange(new BigDecimal("-0.00329335"));
        c3.setDayLow(new BigDecimal("0.04969777"));
        c3.setDayHigh(new BigDecimal("0.05481281"));
        c3.setYearHigh(new BigDecimal("0.17513907"));
        c3.setYearLow(new BigDecimal("0.03996961"));
        c3.setMarketCap(new BigDecimal("17430956.00000000"));
        c3.setPriceAvg50(new BigDecimal("0.05309608"));
        c3.setPriceAvg200(new BigDecimal("0.07735512"));
        c3.setVolume(241751);
        c3.setAvgVolume(231043);
        c3.setExhange("CRYPTO");

        cryptocurrencies.add(c1);
        cryptocurrencies.add(c2);
        cryptocurrencies.add(c3);

        return cryptocurrencies;
    }

    public static List<Historical> generateHistoricals() {

        List<Historical> historicalList = new ArrayList<>();

        Historical h1 = new Historical();
        Historical h2 = new Historical();
        Historical h3 = new Historical();

        h1.setDate(new Date());
        h1.setOpen(new BigDecimal("7878.307617"));
        h1.setHigh(new BigDecimal("8166.554199"));
        h1.setLow(new BigDecimal("7726.774902"));
        h1.setClose(new BigDecimal("8166.554199"));
        h1.setVolume(new BigDecimal("2.8714583843E10"));
        h1.setUnadjustedVolume(new BigDecimal("2.8714583843E10"));
        h1.setChange(new BigDecimal("-288.24658"));
        h1.setChangePercent(new BigDecimal("-3.659"));
        h1.setVwap(new BigDecimal("8019.9611"));
        h1.setLabel("January 10, 20");
        h1.setChangeOverTime(new BigDecimal("-0.03659"));

        h2.setDate(new Date());
        h2.setOpen(new BigDecimal("8082.295898"));
        h2.setHigh(new BigDecimal("8082.295898"));
        h2.setLow(new BigDecimal("7842.403809"));
        h2.setClose(new BigDecimal("7879.071289"));
        h2.setVolume(new BigDecimal("2.4045990465E10"));
        h2.setUnadjustedVolume(new BigDecimal("2.4045990465E10"));
        h2.setChange(new BigDecimal("203.22461"));
        h2.setChangePercent(new BigDecimal("2.514"));
        h2.setVwap(new BigDecimal("8019.9611"));
        h2.setLabel("January 09, 20");
        h2.setChangeOverTime(new BigDecimal("0.02514"));

        h3.setDate(new Date());
        h3.setOpen(new BigDecimal("8161.935547"));
        h3.setHigh(new BigDecimal("8396.738281"));
        h3.setLow(new BigDecimal("7956.774414"));
        h3.setClose(new BigDecimal("8079.862793"));
        h3.setVolume(new BigDecimal("3.1672559264E10"));
        h3.setUnadjustedVolume(new BigDecimal("3.1672559264E10"));
        h3.setChange(new BigDecimal("82.07275"));
        h3.setChangePercent(new BigDecimal("1.006"));
        h3.setVwap(new BigDecimal("78144.4585"));
        h3.setLabel("January 08, 20");
        h3.setChangeOverTime(new BigDecimal("0.01006"));

        historicalList.add(h1);
        historicalList.add(h2);
        historicalList.add(h3);

        return historicalList;

    }
}
