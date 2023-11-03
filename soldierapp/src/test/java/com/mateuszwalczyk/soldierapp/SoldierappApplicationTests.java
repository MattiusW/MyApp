package com.mateuszwalczyk.soldierapp;

import com.mateuszwalczyk.soldierapp.domain.Barrack;
import com.mateuszwalczyk.soldierapp.domain.Soldier;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SoldierappApplicationTests {

	@Autowired
	Barrack barrack;

	@Test
	void contextLoads() {
	}

	@Test
	public void testBarrack(){
		String except = "Black Barrack| Soldier name: Bruce | Age: 29 | Mission: Example Mission";
		assertEquals(except, barrack.toString());
	}

}
