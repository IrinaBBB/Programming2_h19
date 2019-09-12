package password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void returnsFalseIfPasswordHasOtherCharactersThanDigitsAndLetters() {
        assertFalse(Password.checkPassword("343414myPassword@@?"));
    }

    @Test
    void returnTrueIfPasswordHasOnlyLettersAndDigits() {
        assertTrue(Password.checkPassword("234324MySecurePassword"));
    }

    @Test
    void returnFalseIfPasswordHasLessThanTenCharacters() {
        assertFalse(Password.checkPassword("1hi"));
    }

    @Test
    void returnTrueIfPasswordHasMoreThanTenCharacters() {
        assertTrue(Password.checkPassword("1snow214winter"));
    }

    @Test
    void returnTrueIfPasswordHasMoreTenCharacters() {
        assertTrue(Password.checkPassword("123HelloHiBye"));
    }

    @Test
    void returnFalseIfPasswordContainsLessThanThreeDigits() {
        assertFalse(Password.checkPassword("12SnowWinterJanuary"));
    }

    @Test
    void returnTrueIfPasswordContainsMoreThanThreeDigits() {
        assertTrue(Password.checkPassword("12CatsDogsMice45"));
    }

    @Test
    void returnTrueIfPasswordContainsThreeDigits() {
        assertTrue(Password.checkPassword("123CatsDogsMice"));
    }

    @Test
    void returnTrueIfPasswordMeetsTheRequirements() {
        assertTrue(Password.checkPassword("helloMyName123"));
    }

}