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
            companyHashMap.put(line);
        }
        System.out.println("Выберите работу:\n"+
                "1 - добавить компанию\n" +
                "2 - найти компанию\n" +
                "3 - удалить компанию\n" +
                "4 - вывести все компании\n" +
                "5 - выйти из программы\n");
        // 1 - добавить, 2 - найти, 3 - удалить, 4 - вывести
        reader.close();
        while(true){
            Scanner in = new Scanner(System.in);
            int key = in.nextInt();
            switch (key){
                case 1:
                    System.out.println("Введите местоположение компании через пробел, которую хотите добавить");
                    Scanner LineADD = new Scanner(System.in); // Полное местоположение компании через пробел
                    String line_add = LineADD.nextLine();

                    companyHashMap.put(line_add);
                    break;
                case 2:
                    System.out.println("Введите местоположение компании через пробел, которую хотите найти");
                    Scanner LineInSpisiok = new Scanner(System.in); // Полное местоположение компании через пробел
                    String line_in_spisok = LineInSpisiok.nextLine();
                    companyHashMap.FindCompany(line_in_spisok);
                    break;
                case 3:
                    System.out.println("Введите местоположение компании через пробел, которую хотите удалить");
                    Scanner removeCompanyLine = new Scanner(System.in); // Полное местоположение компании через пробел
                    String remove_line = removeCompanyLine.nextLine();
                    companyHashMap.remove(remove_line);
                    break;
                case 4:
                    companyHashMap.Print();
                    break;
                case 5: break;
            }
        }
    }
}