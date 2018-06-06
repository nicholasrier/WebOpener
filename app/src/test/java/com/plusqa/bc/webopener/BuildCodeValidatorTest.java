package com.plusqa.bc.webopener;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuildCodeValidatorTest {

    // Test valid build codes

    @Test
    public void buildCode_HasNoSpecialCharacters_ReturnsTrue() {
        assertTrue(BuildCodeValidator.isValidBuildCode("1A2b3C4d"));
    }

    @Test
    public void buildCode_HasNoMoreThan8Characters_ReturnsTrue() {
        assertTrue(BuildCodeValidator.isValidBuildCode("1A2b3"));
    }

    // Test invalid build codes

    @Test
    public void buildCode_ContainsSpecialCharacters_ReturnsFalse() {
        assertFalse(BuildCodeValidator.isValidBuildCode("1@2b3C4_"));
    }

    @Test
    public void buildCode_HasMoreThan8Characters_ReturnsFalse() {
        assertFalse(BuildCodeValidator.isValidBuildCode("123456789"));
    }
}