package com.service.feign;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceFeignApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class ServiceFeignApplicationTest {

    @Test
    public void doSomeThing() {

        /**
         * playA ---
         */
        int playA = 1;
        int playB = 2;
        int playC = playA + playB;
        System.out.println(playC);
        System.out.println(aaa());

    }

    /**
     *
     * @param name
     * @return
     */
    public String aaa(String name) {


        return "A";
    }
}
