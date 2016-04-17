package norvidi.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Model para uma Person (pessoa).
 *
 * @author Marco Jakob
 */
public class Work {

    private final StringProperty number;
    private final StringProperty client;
    private final StringProperty address;
    private final StringProperty zone;
    private final ObjectProperty<LocalDate> date;
    private final IntegerProperty price;
    private final IntegerProperty iva;
    private final IntegerProperty total;

    /**
     * Construtor padrão.
     */
    public Work() {
        this(null, null, null, null, null, 0, 0, 0);
    }

    /**
     * Construtor com alguns dados iniciais.
     *
     * @param number Primeiro nome da Pessoa.
     * @param client Sobrenome da Pessoa.
     */
    public Work(String number, String client, String address, String zone, LocalDate date, int price, int iva, int total) {
        this.number = new SimpleStringProperty(number);
        this.client = new SimpleStringProperty(client);
        this.address = new SimpleStringProperty(address);
        this.zone = new SimpleStringProperty(zone);
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.price = new SimpleIntegerProperty(price);
        this.iva = new SimpleIntegerProperty(iva);
        this.total = new SimpleIntegerProperty(total);

    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public String getClient() {
        return client.get();
    }

    public void setClient(String client) {
        this.client.set(client);
    }

    public StringProperty clientProperty() {
        return client;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getZone() {
        return zone.get();
    }

    public void setZone(String zone) {
        this.zone.set(zone);
    }

    public StringProperty zoneProperty() {
        return zone;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public IntegerProperty PriceProperty() {
        return price;
    }
    public int getIva() {
        return iva.get();
    }

    public void setIva(int iva) {
        this.iva.set(iva);
    }

    public IntegerProperty IvaProperty() {
        return iva;
    }
    public int getTotal() {
        return total.get();
    }

    public void setTotal(int total) {
        this.total.set(total);
    }

    public IntegerProperty TotalProperty() {
        return total;
    }

}
