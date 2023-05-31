package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.annotation.CheckReturnValue;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@CheckReturnValue

public class TextboxTests {

    @BeforeAll
    static void BeforeAll(){
        Configuration.browser="chrome";
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void sucessTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Vasya");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("vasya@pupkin.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("2741001");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsContainer").$("#subjectsInput").setValue("QA");
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Java.png");
        $("#currentAddress").setValue("Kazansky vokzal");
        $("stateCity-wrapper").$("state").setValue("NCR");
        $("stateCity-wrapper").$("city").setValue("Gurgaon");
        $("submit").click();


$(Selectors.withText("Student Name")).shouldHave(text("Vasya Pupkin"));
$(Selectors.withText("Student Email")).shouldHave(text("vasya@pupkin.com"));
$(Selectors.withText("Gender")).shouldHave(text("Male"));
$(Selectors.withText("Mobile")).shouldHave(text("2741001"));
$(Selectors.withText("Date of Birth")).shouldHave(text("31 May 2023"));
$(Selectors.withText("Subjects")).shouldHave(text("QA"));
 $(Selectors.withText("Hobbies")).shouldHave(text("Reading"));
 $(Selectors.withText("Picture")).shouldHave(text("Java.png"));
 $(Selectors.withText("Address")).shouldHave(text("Kazansky vokzal"));
 $(Selectors.withText("State and City")).shouldHave(text("NCR Gurgaon"));

    }
}
