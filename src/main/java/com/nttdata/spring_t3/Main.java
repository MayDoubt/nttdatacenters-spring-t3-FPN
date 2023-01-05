package com.nttdata.spring_t3;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring_t3.repositories.Client;
import com.nttdata.spring_t3.repositories.ClientRepositoryI;
import com.nttdata.spring_t3.utilities.InterfaceUtils;

/**
 * Taller 3 Spring
 * 
 * Main class
 * 
 * @author Fernando Pérez Nieto
 *
 */
@SpringBootApplication
public class Main implements CommandLineRunner {
	
	/** Logger */
	private static Logger log = LoggerFactory.getLogger(Main.class);
	
	/** Client repository */
	@Autowired
	private ClientRepositoryI clientRepo;

	public static void main(String[] args) {
		log.trace(InterfaceUtils.INIT);
		SpringApplication.run(Main.class, args);
		log.trace(InterfaceUtils.END);
	}

	@Override
	public void run(String... args) throws Exception {
    	
		log.trace(InterfaceUtils.INIT);
    	
    	final Client client1 = new Client();
    	client1.setClientId(1L);
    	client1.setName("Paco");
    	client1.setSurname("Fiestas");
    	LocalDate locald1 = LocalDate.of(1990, 12, 07);
    	Date date1 = Date.valueOf(locald1); 
    	client1.setBirthdate(date1);
    	client1.setDni("12312312A");
    	
    	final Client client2 = new Client();
    	client2.setClientId(2L);
    	client2.setName("Antonio");
    	client2.setSurname("Flores");
    	LocalDate locald2 = LocalDate.of(1997, 01, 15);
    	Date date2 = Date.valueOf(locald2); 
    	client2.setBirthdate(date2);
    	client2.setDni("32132132Z");
    	
    	clientRepo.save(client1);
    	clientRepo.save(client2);
    	
    	System.out.println("Hay añadidos: " + clientRepo.count() + " registros.");
    	
    	List<Client> query = clientRepo.findByNameAndSurname("Paco", "Fiestas");
    	for (Client client : query) {
			System.out.println(client.toString());
		}
    	
    	log.trace(InterfaceUtils.END);
	}
}
