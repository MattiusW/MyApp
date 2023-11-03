package com.mateuszwalczyk.soldierapp.config;

import com.mateuszwalczyk.soldierapp.domain.Barrack;
import com.mateuszwalczyk.soldierapp.domain.Mission;
import com.mateuszwalczyk.soldierapp.domain.Soldier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ImportResource("classpath:config/barrack-config.xml")
@PropertySource("classpath:barrack.properties")
public class MainConfig {

    @Bean
    public Mission createMission(){
        return new Mission();
    }

    @Bean
    public Soldier soldier(){
        Soldier soldier = new Soldier("Arnold", 39);
        soldier.setMission(createMission());
        return soldier;
    }

    @Bean(name="barrack", initMethod = "build", destroyMethod = "tearDown")
    @Value("${my.barrack.name}")
    public Barrack barrack(String name){
        Barrack barrack = new Barrack(soldier());
        barrack.setName(name);
        return barrack;
    }

}
