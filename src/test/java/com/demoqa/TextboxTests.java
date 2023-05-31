package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextboxTests {

    @BeforeAll
    static void BeforeAll(){
        Configuration.browser="chrome";
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void successTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Vasya");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("vasya@pupkin.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("2741001274");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsContainer").$("#subjectsInput").setValue("QA");
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Kazansky vokzal");
        $("#uploadPicture").uploadFromClasspath("Java.png");
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Gurgaon")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Vasya Pupkin"));
        $(".table-responsive").shouldHave(text("vasya@pupkin.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("2741001274"));
        $(".table-responsive").shouldHave(text("31 May,2023"));
        $(".table-responsive").shouldHave(text("Kazansky vokzal"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Gurgaon"));


    }
}
