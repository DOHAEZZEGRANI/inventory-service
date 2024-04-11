package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


    @SpringBootApplication
    public class InventoryServiceApplication implements CommandLineRunner {

        public static void main(String[] args) {
            SpringApplication.run(InventoryServiceApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
        }
    }
