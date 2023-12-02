/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 *
 * @author xhesm
 */
public class UtilEmailSender {

    public static void main11(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "pruebacesars@yopmail.com";

        // Sender's email ID needs to be mentioned
        String from = "cesarsdev@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        String password = "rvyyonirqweynqxq";
        // Get system properties
        Properties properties = System.getProperties();
 

        // Setup mail server
        //properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");

        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() { 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication(from, password); 
            }

        });
        //getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /*
    public static void main(String[] args) {
        try {
            enviarInformePorCorreo();
        } catch (MessagingException ex) {
            Logger.getLogger(UtilEmailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(UtilEmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    private static void enviarInformePorCorreo() throws MessagingException, JRException {
        // Configuración de las propiedades para la conexión con el servidor de correo

        // Sender's email ID needs to be mentioned
        String from = "cesarsdev@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        String password = "rvyyonirqweynqxq";
        // Get system properties
        Properties properties = System.getProperties(); 

        // Setup mail server
        //properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");

        // Crear una sesión de correo
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Aquí debes colocar tu dirección de correo electrónico y tu contraseña
                return new PasswordAuthentication(from, password);
            }
        });

        // Crear un mensaje de correo
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("23100201@ue.edu.pe"));
        message.setSubject("Informe JasperReports adjunto");

        // Crear el cuerpo del mensaje
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Adjunto encontrarás el informe generado con JasperReports.");

        // Crear el informe como archivo adjunto
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        String filePath = "config/temporal-reports/informe.pdf";  // Reemplaza con la ruta real de tu informe
        DataSource source = new FileDataSource(filePath);
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName("Informe.jasper.pdf");

        // Combinar el cuerpo del mensaje y el archivo adjunto
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        // Configurar el mensaje con el contenido combinado
        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);

        System.out.println("Informe enviado por correo electrónico exitosamente.");
    }

}
