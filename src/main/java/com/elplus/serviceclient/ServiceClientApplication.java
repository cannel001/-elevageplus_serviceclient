package com.elplus.serviceclient;

import com.elplus.serviceclient.domaine.Client;
import com.elplus.serviceclient.domaine.Note;
import com.elplus.serviceclient.repositories.ClientRepository;
import com.elplus.serviceclient.repositories.NoteRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceClientApplication implements CommandLineRunner {

    //les proprietes
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private NoteRepository noteRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //liste des clients
        List<Client> clients = Arrays.asList(
                new Client("Hotel Belle cote", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh5.googleusercontent.com/proxy/DK7zP1wZEyXu_vlpeeFYFCTJV1hOVS_mIYknBBFUYZxeM1YPu5YjNrNvyjoC-8V0CzJNDz6N_3j2CXxGta09fQ31ggAzQYLBssN3F-rByxYO3tNXt1P8qyRJBSG1qcDIpLk4ORYSrZJzguZRGz9kkm6e1Rf89fQ=w408-h266-k-no", "mon pays", "ma ville", "latitude", "longitude"),
                new Client("Résidence Rose Hermine", "14 bp 1731 abidjan 14", "0022503336555", "ma description", "https://lh5.googleusercontent.com/proxy/DK7zP1wZEyXu_vlpeeFYFCTJV1hOVS_mIYknBBFUYZxeM1YPu5YjNrNvyjoC-8V0CzJNDz6N_3j2CXxGta09fQ31ggAzQYLBssN3F-rByxYO3tNXt1P8qyRJBSG1qcDIpLk4ORYSrZJzguZRGz9kkm6e1Rf89fQ=w408-h266-k-no", "Cote d'ivoire", "ma ville", "latitude", "longitude"),
                new Client("Résidences Touristhotel", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh4.googleusercontent.com/proxy/XJr8PwH4y_iq6MsocJn9QNLnlfmNTDRsrVrHoUrTQoJRS49vZ2fREKaDccWOe1td3TL08T79VeZLmCM2jP5BWZwm9AObHMl6u7frz_Eq-CwCefwuZbHRjgk0dLbvp_2TAnlrrMJQqAQSn7Uxqt5admI5OS_i7Q=w408-h271-k-no", "Cote d'ivoire", "Abidjan", "5.3880047", "-3.974675,16"),
                new Client("Restaurant Regina Margherita", "14 bp 1731 abidjan 14", "0022503336555", "ma description", "https://lh5.googleusercontent.com/p/AF1QipNfbOuAtX9cUvDjVydAOzTU2QPQLh8YSuWZtVXP=w408-h229-k-no", "Cote d'ivoire", "Abidjan", "latitude", "longitude"),
                new Client("Norima", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh5.googleusercontent.com/p/AF1QipOfvH80QBe7P4FwnZxSHUhKQ-rw18cCl01kfDDg=w408-h270-k-no", "Cote d'ivoire", "Abidjan", "5.3635796", "-3.9941341,17"),
                new Client("Chez Georges Resto", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh5.googleusercontent.com/p/AF1QipOfvH80QBe7P4FwnZxSHUhKQ-rw18cCl01kfDDg=w408-h270-k-no", "Cote d'ivoire", "Abidjan", "5.3635796", "-3.9941341,17"),
                new Client("Maquis du Val","14 bp 1731 abidjan 14", "0022503336555", "ma description", "https://lh5.googleusercontent.com/p/AF1QipNCWJJuylgtF6Iih7QYZEsj5kIgJyZF700z8dJ6=w408-h306-k-no", "Cote d'ivoire", "Abidjan", "5.3338744", "-4.0003919,17"),
                new Client("Espace 331", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh3.googleusercontent.com/proxy/hCXbKj4KfhN0gEndSVpn-DVFBmVH6EU3GNrRbWG2TzjFo86LwKo04rMl_s9Rpn8Lf_L5PxLX8JMvlsVOsSTZkmAZGABficgRlA5T7slIVv5nVILhrc3uX4U_Whh2CtiFS0TFoJvaF0kLkzSgON9EyAVGJKXVLY0=w408-h256-k-no", "Cote d'ivoire", "Abidjan", "5.3393505", "-4.0020138,17"),
                new Client("le Che café", "14 bp 1731 abidjan 14", "0022503336555", "ma description", "https://lh5.googleusercontent.com/p/AF1QipNRXAdvu-b_H68OOeADbJq_pAroM7oyKRLPAy2u=w408-h544-k-no", "Cote d'ivoire", "Abidjan", "5.2821292", "-3.9776812,17"),
                new Client("Hippopotamus", "14 bp 1731 abidjan 14", "0022578134448", "ma description", "https://lh5.googleusercontent.com/p/AF1QipM4sHpFLxgBCuGALg1LiOPbPJCedQxbVEmacOO2=w408-h544-k-no", "Cote d'ivoire", "Abidjan", "5.3236734", "-4.0190231,17")
        );
        
        //liste des notes
        List<Note> notes= Arrays.asList(
        new Note(Double.valueOf(4), clientRepository.getOne(1L)),
        new Note(Double.valueOf(1), clientRepository.getOne(2L)),
        new Note(Double.valueOf(3), clientRepository.getOne(3L)),
        new Note(Double.valueOf(4), clientRepository.getOne(4L)),
        new Note(Double.valueOf(5), clientRepository.getOne(5L)),
        new Note(Double.valueOf(0), clientRepository.getOne(6L)),
        new Note(Double.valueOf(4), clientRepository.getOne(7L)),
        new Note(Double.valueOf(1), clientRepository.getOne(8L)),
        new Note(Double.valueOf(2), clientRepository.getOne(9L)),
        new Note(Double.valueOf(4), clientRepository.getOne(10L)));
        
        //enregistrement des clients
        clients.forEach(v->clientRepository.saveAndFlush(v));
        
        //enregistrement des notes
        notes.forEach(v->noteRepository.saveAndFlush(v));

    }

}
