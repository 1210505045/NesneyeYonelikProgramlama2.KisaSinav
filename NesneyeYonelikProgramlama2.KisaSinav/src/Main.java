
import java.util.ArrayList;
import java.util.List;

interface Displayable {
    void displayInfo();
}

class Konut implements Displayable {
    String name;

    Konut(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Konut Name: " + name);
    }
}

class Bina extends Konut {
    private int numberOfFloors;

    public Bina(String binaAdi, int numberOfFloors) {
        super(binaAdi);
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bina Kat Sayısı: " + getNumberOfFloors());
    }
}

class Daire extends Konut {
    private int apartmentNumber;
    private int binaNumarasi;

    public Daire(String daireAdi, int apartmentNumber, int binaNumarasi) {
        super(daireAdi);
        this.apartmentNumber = apartmentNumber;
        this.binaNumarasi = binaNumarasi;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getBinaNumarasi() {
        return binaNumarasi;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Daire Numarası: " + getApartmentNumber());
        System.out.println("Bina Numarası: " + getBinaNumarasi());
    }
}

class Kiraci implements Displayable {
    private String adi;
    private String soyadi;
    private String evSahibi;
    private Konut konut;
    private List<Konut> apartments;

    public Kiraci(String adi, String soyadi, String evSahibi, Konut konut) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.evSahibi = evSahibi;
        this.konut = konut;
        this.apartments = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Adı: " + adi);
        System.out.println("Soyadı: " + soyadi);
        System.out.println("Ev Sahibi: " + evSahibi);
        konut.displayInfo();
        System.out.println("Kiradığı Konutlar:");
        for (Konut apartment : apartments) {
            apartment.displayInfo();
        }
    }

    public void addApartment(Konut konut) {
        apartments.add(konut);
    }
}

public class Main {
    public static void main(String[] args) {
        Konut bina = new Bina("Küçük Kayırı", 4);
        Kiraci kiraci = new Kiraci("Ahmet", "Vural", "Serhat", bina);
        kiraci.addApartment(new Daire("Daire 101", 101, 1));
        kiraci.addApartment(new Daire("Daire 201", 201, 2));
        kiraci.displayInfo();
    }
}