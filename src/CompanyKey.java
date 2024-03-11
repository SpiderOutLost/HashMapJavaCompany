import java.util.Objects;
import java.util.StringTokenizer;

public class CompanyKey {
    private String Country;
    private String City;
    private String Street;
    private String NumberHouse;

    CompanyKey(String line){
        String[] lines = line.split(" ");
        this.Country = lines[0];
        this.City = lines[1];
        this.Street = lines[2];
        this.NumberHouse = lines[3];

    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public String getNumberHouse() {
        return NumberHouse;
    }

    public String PrintCompanyKey(){
        return getCountry() + " " + getCity() + " " + getStreet() + " " + getNumberHouse();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CompanyKey that = (CompanyKey) object;
        return Objects.equals(Country, that.Country) && Objects.equals(City, that.City) && Objects.equals(Street, that.Street) && Objects.equals(NumberHouse, that.NumberHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Country, City, Street, NumberHouse);
    }
}
