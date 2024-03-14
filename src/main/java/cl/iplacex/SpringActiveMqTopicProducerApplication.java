package cl.iplacex;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cl.iplacex.jms.JmsPublisher;
import cl.iplacex.models.Company;
import cl.iplacex.models.Product;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication implements CommandLineRunner {

    @Autowired
    JmsPublisher publisher;

    public static void main(String[] args){ SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);}

    @Override
    public void run(String... args) throws Exception{

        Product iphone7 = new Product("Iphone 7");
        Product iPadPro = new Product("iPadPro");
        List<Product> appleProducts = new ArrayList<>(Arrays.asList(iphone7, iPadPro));
        Company apple = new Company("Apple", appleProducts);
        iphone7.setCompany(apple);
        iPadPro.setCompany(apple);

        publisher.send(apple);

        Product galaxyS8 = new Product("Galaxy S8");
        Product gears3 = new Product("Gear S3");
        List<Product> samsungProducts = new ArrayList<>(Arrays.asList(galaxyS8, gears3));
        Company samsung = new Company("Samsung", samsungProducts);
        galaxyS8.setCompany(samsung);
        gears3.setCompany(samsung);

        publisher.send(samsung);

    }

}
