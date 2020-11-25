package com;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.entities.Act;
import com.entities.Consultation;
import com.entities.FicheMedicale;
import com.entities.Medecin;
import com.entities.Patient;
import com.entities.Specialite;
import com.entities.Utilisateur;
import com.service.ActService;
import com.service.ConsultationService;
import com.service.FicheMedicaleService;
import com.service.MedecinService;
import com.service.PatientService;
import com.service.SpecialiteService;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionRdvApplication {
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("Spring boot application runing in utc timezone:"+ new Date());
	}


	public static void main(String[] args) {
		SpringApplication.run(GestionRdvApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start( SpecialiteService specialiteservice,
			MedecinService medecinService,
			PatientService patientService,
			ActService actService,
			FicheMedicaleService ficheService,
			ConsultationService consultationService) {
		Specialite s1 = new Specialite(null, "Dentiste", null);
		Specialite s2 = new Specialite(null, "Orthophoniste", null);
		Specialite s3 = new Specialite(null, "Chirugien", null);
		Specialite s4 = new Specialite(null, "Dénéraliste", null);
		Specialite s5 = new Specialite(null, "Promptologue", null);
		Medecin m1 = new Medecin(10,"codePublic", null, s1, null, null);
		Medecin m2 = new Medecin(20,"codePublic", null, s2, null, null);
		Medecin m3 = new Medecin(30,"codePublic", null, s3, null, null);
		Medecin m4 = new Medecin(40,"codePublic", null, s4, null, null);
		Medecin m5 = new Medecin(50,"codePublic", null, s5, null, null);
		Patient p1 = new Patient("65465465465465", null, m1, null, null);
		Patient p2 = new Patient("46546513213265", null, m2, null, null);
		Patient p3 = new Patient("46568798651328", null, m3, null, null);
		Patient p4 = new Patient("13768798798523", null, m4, null, null);
		Patient p5 = new Patient("13246565768798", null, m5, null, null);
		m1.setNom("MAS"); m1.setPrenom("Dominique"); m1.setPassword("azeaze"); m1.setEmail("emailm1");
		m2.setNom("MONTEL"); m2.setPrenom("Marie-Anne"); m2.setPassword("azeaze"); m2.setEmail("emailm2");
		m3.setNom("QUENTIN"); m3.setPrenom("Floriane"); m3.setPassword("azeaze"); m3.setEmail("emailm3");
		m4.setNom("CAZABAN"); m4.setPrenom("Sophie"); m4.setPassword("azeaze"); m4.setEmail("emailm4");
		m5.setNom("LORIN"); m5.setPrenom("Felicie"); m5.setPassword("azeaze"); m5.setEmail("emailm5");
		p1.setNom("GAGNE"); p1.setPrenom("Christine"); p1.setPassword("azeaze"); p1.setEmail("emailp1");
		p2.setNom("BRUNAULT"); p2.setPrenom("Lirienne"); p2.setPassword("azeaze"); p2.setEmail("emailp2");
		p3.setNom("PARISEAU"); p3.setPrenom("Marcel"); p3.setPassword("azeaze"); p3.setEmail("emailp3");
		p4.setNom("CYR"); p4.setPrenom("Arridano"); p4.setPassword("azeaze"); p4.setEmail("emailp4");
		p5.setNom("BERGER"); p5.setPrenom("Fusberta"); p5.setPassword("azeaze"); p5.setEmail("emailp5");
		Consultation c1 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "bien", false, false, 60, 0 , m1, p1);
		Consultation c2 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(11, 00), ZoneId.of("Europe/Paris") ), "pas bien", false, false, 60, 0, m2, p2);
		Consultation c3 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(11, 00), ZoneId.of("Europe/Paris") ), "RAS", false, false, 60, 0, m1, p3);
		Consultation c4 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(14, 00), ZoneId.of("Europe/Paris") ), "OK", false, false, 60, 0, m1, p4);
		Consultation c5 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(15, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m2, p4);
		Consultation c6 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(16, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, true, 60, 0, m3, p4);
		Consultation c7 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 20), LocalTime.of(14, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m3, p4);
		Consultation c8 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 19), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, true, 30, 0, m4, p4);
		Consultation c9 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 20), LocalTime.of(15, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m2, p4);
		Consultation c10 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 28), LocalTime.of(11, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 30, 0, m5, p4);
		Consultation c11 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 30), LocalTime.of(15, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, true, 60, 0, m3, p4);
		Consultation c12 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 28), LocalTime.of(9, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, true, 30, 0, m5, p4);
		Consultation c13 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 28), LocalTime.of(16, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m2, p4);
		Consultation c14 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 28), LocalTime.of(14, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m2, p4);
		Consultation c15 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 29), LocalTime.of(13, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, true, 30, 0, m2, p4);
		Consultation c16 = new Consultation(null, ZonedDateTime.of(LocalDate.of(2020, 11, 15), LocalTime.of(15, 00), ZoneId.of("Europe/Paris") ), "visite médicale", false, false, 60, 0, m2, p4);
		FicheMedicale f1 = new FicheMedicale(null, "fiche médicale du patient", ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "antécédent", "observations", p1);
		FicheMedicale f2 = new FicheMedicale(null, "fiche médicale du patient", ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "antécédent", "observations", p2);
		FicheMedicale f3 = new FicheMedicale(null, "fiche médicale du patient", ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "antécédent", "observations", p3);
		FicheMedicale f4 = new FicheMedicale(null, "fiche médicale du patient", ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "antécédent", "observations", p4);
		FicheMedicale f5 = new FicheMedicale(null, "fiche médicale du patient", ZonedDateTime.of(LocalDate.of(2020, 11, 27), LocalTime.of(10, 00), ZoneId.of("Europe/Paris") ), "antécédent", "observations", p5);
		Act a1 = new Act(null, "Tamponnement nasal antérieur", 25.50f, null);
		Act a2 = new Act(null, "Prélèvement de sang artériel, par voie transcutanée", 25.50f, null);
		Act a3 = new Act(null, "Anesthésie rachidienne au cours d'un accouchement par voie basse", 50.50f, null);
		Act a4 = new Act(null, "Section de bride et/ou d'adhérences péritonéales pour occlusion intestinale aigüe, par laparotomie", 15.50f, null);
		Act a5 = new Act(null, "Échographie de surveillance de la croissance foetale", 125.50f, null);
		return (args)->{
			Stream.of(s1,s2,s3,s4,s5).forEach( item ->specialiteservice.saveOrUpdate( item ) );
			Stream.of(m1,m2,m3,m4,m5).forEach( item ->medecinService.saveOrUpdate( item ) );
			Stream.of(p1,p2,p3,p4,p5).forEach( item ->patientService.saveOrUpdate( item ) );
			Stream.of(a1,a2,a3,a4,a5).forEach( item ->actService.saveOrUpdate( item ) );
			Stream.of(f1,f2,f3,f4,f5).forEach( item ->ficheService.saveOrUpdate( item ) );
			Stream.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16).forEach( item ->consultationService.saveOrUpdate( item ) );
			specialiteservice.findAll().forEach(System.out::println);
		};
		
	}
	

	
}
