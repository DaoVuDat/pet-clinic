package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetTypeService;
import com.example.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Method 1
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }



    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogSavedPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catSavedPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Street A");
        owner1.setCity("City A");
        owner1.setTelephone("123456");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dogSavedPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennae");
        owner2.setAddress("123 Street B");
        owner2.setCity("City B");
        owner2.setTelephone("654321");
        ownerService.save(owner2);

        Pet fionaCat = new Pet();
        fionaCat.setPetType(catSavedPetType);
        fionaCat.setOwner(owner2);
        fionaCat.setBirthday(LocalDate.now());
        fionaCat.setName("Just Cat");
        owner2.getPets().add(fionaCat);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Potter");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
