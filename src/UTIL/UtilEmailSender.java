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

    private String correo_receptor;
    private List<String> paths;
    private String asunto;
    private String contenido;

    public boolean enviarInformePorCorreo() throws MessagingException {
        try {
            // Configuración de las propiedades para la conexión con el servidor de correo

            String from = "cesarsdev@gmail.com";
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
            properties.put("mail.debug", "false");

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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getCorreo_receptor()));
            message.setSubject(this.getAsunto());

            // Crear el cuerpo del mensaje
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(this.getContenido());

            // Crear el informe como archivo adjunto
            for (String filePath : getPaths()) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                //String filePath = "config/temporal-reports/informe.pdf";  // Reemplaza con la ruta real de tu informe
                DataSource source = new FileDataSource(filePath);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                String name = filePath.substring(filePath.lastIndexOf("/"));
                attachmentBodyPart.setFileName(name);
                // Combinar el cuerpo del mensaje y el archivo adjunto
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                multipart.addBodyPart(attachmentBodyPart);

                // Configurar el mensaje con el contenido combinado
                message.setContent(multipart);
            }
            // Enviar el mensaje
            Transport.send(message);
            return true;
            //System.out.println("Informe enviado por correo electrónico exitosamente.");
        } catch (MessagingException ex) {
            return false;
            //   Logger.getLogger(UtilEmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCorreo_receptor() {
        return correo_receptor;
    }

    public void setCorreo_receptor(String correo_receptor) {
        this.correo_receptor = correo_receptor;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
