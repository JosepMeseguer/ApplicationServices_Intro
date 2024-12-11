package com.example.softlearning;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.softlearning.applicationcore.entity.client.appservices.getClientByIdController;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@SpringBootApplication
public class SoftlearningApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftlearningApplication.class, args);

        System.out.println("\n *****   APPSERVICES   ***** \n");

        System.out.println("\n *****   AppService Clients_by_id   ***** \n");
        var clientByIdController = context.getBean(getClientByIdController.class);
		try {
            System.out.println("\n *****   JSON DOCUMENT   ***** \n");
            System.out.println(clientByIdController.getJson(1003));
            System.out.println("\n *****   XML DOCUMENT   ***** \n");
            System.out.println(clientByIdController.getXML(1003));
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }		
	}
}