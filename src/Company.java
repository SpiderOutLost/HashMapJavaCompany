public class Company {
    private String Country;
    private String City;
    private String Street;
    private String NumberHouse;

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
    public boolean equals(Object object){
        if (object instanceof Company){
            Company company = (Company) object;
            return this.Country.equals(company.Country)&&
                    this.City.equals(company.City)&&
                    this.Street.equals(company.Street)&&
                    this.NumberHouse.equals(company.NumberHouse);
        }
        else {
            return false;
        }
    }
    public int hashode(){
        return this.City.hashCode() + this.NumberHouse.hashCode();
    }
}
