package edu.dl.project01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HumanRepositoryTest {

    @Autowired
    HumanRepository humanRepository;

    @Test
    @Transactional
    public void testHuman(){
        Human human = new Human();
        human.setName("Alan");

        //DB에 값을 넣고
        Long savedId = humanRepository.save(human);

        //DB에 을 읽어오고
        Human findHuman = humanRepository.find(savedId);

        System.out.println("#findHuman.getId()"+ findHuman.getId());
        System.out.println("#human.getId()"+ human.getId());
        System.out.println("#findHuman.getName()"+ findHuman.getName());
        System.out.println("#human.getName()"+ human.getName());

        Assertions.assertEquals(findHuman.getId(), human.getId());
        Assertions.assertEquals(findHuman.getName(), human.getName());

    }

    /*
    @Test
    void save() {
    }

    @Test
    void find() {
    }
    */
}