package com.vaulin1506;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationForm {

    String name = "test_user@stanzza.ru";

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://stanzza.aicrobotics.ru";
    }

    @Test
    public void loginLogout() {
        open("/authorization");
        $(By.xpath("(//input[@name=''])[1]")).setValue(name);
        $(By.xpath("(//input[@name=''])[2]")).setValue("*$#H4eAPoCjoZ6");
        $(".brand-button__content").click();
        $(By.cssSelector(".user__content")).shouldHave(text(name));
        $(By.cssSelector(".the-header__title-wrapper")).click();
        $(By.cssSelector(".the-header__action")).click();

        refresh(); // TODO: 01.09.2023 костыль, окно должно появляться без обновления
    }

    @Test
            public void resetPassword() {
        open("/authorization");
        $(By.cssSelector(".brand-input__reset")).click();
        $(By.cssSelector(".brand-input__field")).setValue(name);
        $(By.cssSelector(".password-reset__submit")).click();
        $(By.cssSelector(".authorization__auth-block"));
    }
}

