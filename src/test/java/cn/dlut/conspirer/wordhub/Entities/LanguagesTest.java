package cn.dlut.conspirer.wordhub.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguagesTest {
    @Test
    void test_lang() {
        Languages lang = Languages.Test;
        assertEquals(lang.name(), "Test");
        assertEquals(Languages.valueOf("Test"), lang);
    }
}