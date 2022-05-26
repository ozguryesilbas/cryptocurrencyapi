package hi.cryptocurrencyapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cryptocurrency", indexes = {@Index(columnList = "symbol", name = "indx_symbol")})
public class Cryptocurrency extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private String symbol;
    private BigDecimal price;
    private BigDecimal changesPercentage;
    private BigDecimal change;
    private BigDecimal dayLow;
    private BigDecimal dayHigh;
    private BigDecimal yearHigh;
    private BigDecimal yearLow;
    private BigDecimal marketCap;
    private BigDecimal priceAvg50;
    private BigDecimal priceAvg200;
    private Integer volume;
    private Integer avgVolume;
    private String exhange;
    private String currencyName;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(BigDecimal changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(BigDecimal yearHigh) {
        this.yearHigh = yearHigh;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getYearLow() {
        return yearLow;
    }

    public void setYearLow(BigDecimal yearLow) {
        this.yearLow = yearLow;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getPriceAvg50() {
        return priceAvg50;
    }

    public void setPriceAvg50(BigDecimal priceAvg50) {
        this.priceAvg50 = priceAvg50;
    }

    @Column(precision = 19, scale = 8)
    public BigDecimal getPriceAvg200() {
        return priceAvg200;
    }

    public void setPriceAvg200(BigDecimal priceAvg200) {
        this.priceAvg200 = priceAvg200;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(Integer avgVolume) {
        this.avgVolume = avgVolume;
    }

    public String getExhange() {
        return exhange;
    }

    public void setExhange(String exhange) {
        this.exhange = exhange;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
