import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        CompanyHashMap companyHashMap = new CompanyHashMap();
        BufferedReader reader = new BufferedReader(new FileReader("src/Companies.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            String[] lines = line.split(":");
            CompanyKey companyKey = new CompanyKey(lines[0]);
            Company company = new Company(lines[1]);
            companyHashMap.put(companyKey, company);
        }
        companyHashMap.Print();
    }
}