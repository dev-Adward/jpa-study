package com.example.advanced.entity.hospital;


import com.example.advanced.repository.hospital.PetRepository;
import com.example.advanced.type.GenderType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class PetRepositoryTests {
    @Autowired
    PetRepository petRepository;

    @Test
    public void saveTest() {
        Owner owner = new Owner();
        owner.setOwnerName("유찬");
        owner.setOwnerPhone("101010101010");

        Pet pet = new Pet();
        pet.setOwner(owner);
        pet.setPetDisease("감기");
        pet.setPetGender(GenderType.FEMALE);
        pet.setPetName("순딩이");

        Pet pet2 = new Pet();
        pet2.setOwner(owner);
        pet2.setPetDisease("고지혈증");
        pet2.setPetGender(GenderType.FEMALE);
        pet2.setPetName("");

        petRepository.save(pet);

    }

    @Test
    public void findAllTest(){
        log.info(petRepository.findAll().toString());
    }
}
