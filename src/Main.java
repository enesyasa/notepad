import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dosyaYolu = "notlar.txt";

        // Dosyadan metni oku ve ekrana yazdır
        try {
            FileReader fileReader = new FileReader(dosyaYolu);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();
            System.out.println("Kaydedilen Metin:");
            while (okunanMetin != null) {
                System.out.println(okunanMetin);
                okunanMetin = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }

        // Kullanıcıdan metin al ve dosyaya yaz
        System.out.print("Lütfen bir metin giriniz: ");
        String metin = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(dosyaYolu);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(metin);
            printWriter.close();
            System.out.println("Metininiz başarıyla kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }

        scanner.close();
    }
}
