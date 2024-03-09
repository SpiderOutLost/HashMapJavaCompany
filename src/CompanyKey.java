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

    @Override
    public boolean equals(Object o) {
        if (o instanceof CompanyKey){
            CompanyKey companyKey = (CompanyKey) o;
            return companyKey.getCountry().equals(this.Country)&&
                    companyKey.getCity().equals(this.City)&&
                    companyKey.getStreet().equals(this.Street)&&
                    companyKey.getNumberHouse().equals(this.NumberHouse);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return City.hashCode() + NumberHouse.hashCode();
    }
}
