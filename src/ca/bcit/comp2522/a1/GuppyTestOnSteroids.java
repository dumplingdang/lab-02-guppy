package ca.bcit.comp2522.a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Here are *some* unit tests for your Guppy.
 *
 * Drag and drop this file into your A1 IntelliJ project.
 *
 * Ensure this file and your Guppy are in package ca.bcit.comp2522.a1 please.
 *
 * I have left some very important unit tests out.
 *
 * I have a bonus for you. You can earn up to 5% extra (to a maximum of 100%)
 * if you create some unit tests for your code.
 *
 * Some very things I have not tested include:
 * 1. ensuring equals and hashCode work correctly and do not consider generation
 *    number or ID when comparing two Guppy instances for equality
 * 2. Making sure the toString is correct
 * 3. And others.
 *
 * I invite you to collaborate as a cohort and augment this JUnit
 * file with the tests that are missing. Work together to make this
 * JUnit test file complete and include it with your solution.
 *
 * There are 41 tests here. By my reckoning, we are missing enough meaningful
 * tests to bring that closer to 50, maybe 60. What have we forgotten to test?
 */
class GuppyTestOnSteroids {

    private Guppy zeroParamGuppy;
    private Guppy testGuppy;

    @BeforeEach
    public void setUp() throws Exception {

        zeroParamGuppy = new Guppy();
        testGuppy = new Guppy(  "Poecilia",
                "reticulata",
                1,
                true,
                3,
                0.75);
    }

    @Test
    public void containsConstantCalledYOUNG_FISH_AGE_IN_WEEKS() {
        assertEquals(10, Guppy.YOUNG_FISH_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMATURE_FISH_AGE_IN_WEEKS() {
        assertEquals(30, Guppy.MATURE_FISH_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMAXIMUM_AGE_IN_WEEKS() {
        assertEquals(50, Guppy.MAXIMUM_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMINIMUM_WATER_VOLUME_ML() {
        assertEquals(250.0, Guppy.MINIMUM_WATER_VOLUME_ML, 0.0);
    }

    @Test
    public void containsConstantCalledDEFAULT_GENUS() {
        assertTrue(Guppy.DEFAULT_GENUS.equals("Poecilia"));
    }

    @Test
    public void containsConstantCalledDEFAULT_SPECIES() {
        assertTrue(Guppy.DEFAULT_SPECIES.equals("reticulata"));
    }

    @Test
    public void containsConstantCalledDEFAULT_HEALTH_COEFFICIENT() {
        assertEquals(0.5, Guppy.DEFAULT_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMINIMUM_HEALTH_COEFFICIENT() {
        assertEquals(0.0, Guppy.MINIMUM_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMAXIMUM_HEALTH_COEFFICIENT() {
        assertEquals(1.0, Guppy.MAXIMUM_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void staticGuppyCounterIsCorrectlyTrackingNewbornGuppiesInZeroParamConstructor() {
        final int numberAlreadyCreated = Guppy.getNumberOfGuppiesBorn();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy someGuppy = new Guppy();
        }
        assertEquals(numberAlreadyCreated + numberCreated, Guppy.getNumberOfGuppiesBorn());
    }

    @Test
    public void staticGuppyCounterIsCorrectlyTrackingNewbornGuppiesInMultiParamConstructor() {
        final int numberAlreadyCreated = Guppy.getNumberOfGuppiesBorn();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i)
            new Guppy("Poecilia",
                    "reticulata",
                    1,
                    true,
                    3,
                    0.75);
        assertEquals(numberAlreadyCreated + numberCreated, Guppy.getNumberOfGuppiesBorn());
    }

    @Test
    public void zeroParamGuppyIsSetToCorrectValues() {
        assertTrue(zeroParamGuppy.getGenus().equals("Poecilia"));
        assertTrue(zeroParamGuppy.getSpecies().equals("reticulata"));
        assertEquals(0, zeroParamGuppy.getAgeInWeeks());
        assertTrue(zeroParamGuppy.getIsFemale());
        assertEquals(0, zeroParamGuppy.getGenerationNumber());
        assertTrue(zeroParamGuppy.getIsAlive());
        assertEquals(0.5, zeroParamGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void multiParamGuppyIsSetToCorrectValues() {
        assertTrue(testGuppy.getGenus().equals("Poecilia"));
        assertTrue(testGuppy.getSpecies().equals("reticulata"));
        assertEquals(1, testGuppy.getAgeInWeeks());
        assertTrue(testGuppy.getIsFemale());
        assertEquals(3, testGuppy.getGenerationNumber());
        assertTrue(testGuppy.getIsAlive());
        assertEquals(0.75, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInZeroParamConstruction() {
        Guppy first = new Guppy();
        int firstID = first.getIdentificationNumber() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy fry = new Guppy();
            assertEquals(firstID + i, fry.getIdentificationNumber());
        }
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Guppy first = new Guppy();
        int firstID = first.getIdentificationNumber() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy fry = new Guppy("Poecilia",
                    "reticulata",
                    1,
                    true,
                    3,
                    0.75);
            assertEquals(firstID + i, fry.getIdentificationNumber());
        }
    }

    @Test
    public void genusAndSpeciesAreCorrectlyFormattedAndStored() {
        Guppy fry = new Guppy("  poECILIA    ",
                "  retICUlata   ",
                1,
                true,
                3,
                0.75);
        assertTrue(fry.getGenus().equals("Poecilia"));
        assertTrue(fry.getSpecies().equals("reticulata"));
    }

    @Test
    public void nullGenusReplacedWithDefaultGenus() {
        Guppy fry = new Guppy(null,
                "a",
                0,
                true,
                0 ,
                0.5);
        assertTrue(fry.getGenus().equals("Poecilia"));
    }

    @Test
    public void emptyGenusReplacedWithDefaultGenus() {
        Guppy fry = new Guppy("    ",
                "a",
                0,
                true,
                0 ,
                0.5);
        assertTrue(fry.getGenus().equals("Poecilia"));

    }

    @Test
    public void nullSpeciesReplacedWithDefaultSpecies() {
        Guppy fry = new Guppy("a",
                null,
                0,
                true,
                0 ,
                0.5);
        assertTrue(fry.getSpecies().equals("reticulata"));

    }

    @Test
    public void emptySpeciesReplacedWithDefaultSpecies() {
        Guppy fry = new Guppy("a",
                "    ",
                0,
                true,
                0 ,
                0.5);
        assertTrue(fry.getSpecies().equals("reticulata"));

    }

    @Test
    public void negativeAgeInWeeksBecomesZero() {
            Guppy fry = new Guppy("a",
                "b",
                -1,
                true,
                0 ,
                0.5);
        assertTrue(fry.getAgeInWeeks() == 0);
    }

    @Test
    public void zeroAgeInWeeksRemainsZero() {
        Guppy fry = new Guppy("a",
                "b",
                -1,
                true,
                0 ,
                0.5);
        assertTrue(fry.getAgeInWeeks() == 0);
    }

    @Test
    public void maximumAgeInWeeksIsAlive() {
        Guppy fry = new Guppy("a",
                "b",
                Guppy.MAXIMUM_AGE_IN_WEEKS,
                true,
                0 ,
                0.5);
        assertTrue(fry.getIsAlive() == true);
    }

    @Test
    public void overlargeAgeInWeeksIsReducedToMax() {
        Guppy fry = new Guppy("a",
                "b",
                (Guppy.MAXIMUM_AGE_IN_WEEKS + 100),
                true,
                0 ,
                0.5);
        assertTrue(fry.getAgeInWeeks() == Guppy.MAXIMUM_AGE_IN_WEEKS);
    }

    @Test
    public void negativeGenerationNumberSetToZero() {
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                -1,
                0.5);
        assertTrue(fry.getGenerationNumber() == 0);
    }

    @Test
    public void zeroGenerationNumberSetToZero() {
        Guppy fry = new Guppy("a",
                "b",
                0,
                true, 0,
                0.5);
        assertTrue(fry.getGenerationNumber() == 0);
    }

    @Test
    public void createGuppyWithNegativeHealthCoefficient() {
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                0,
                Guppy.MINIMUM_HEALTH_COEFFICIENT - 1.0);
        assertTrue(fry.getHealthCoefficient() == Guppy.MINIMUM_HEALTH_COEFFICIENT);
    }

    @Test
    public void createGuppyWithOverlargeHealthCoefficient() {
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                0,
                Guppy.MAXIMUM_HEALTH_COEFFICIENT + 1.0);
        assertTrue(fry.getHealthCoefficient() == Guppy.MAXIMUM_HEALTH_COEFFICIENT);

    }

    @Test
    public void testIncrementAge() {
        int oldAge = testGuppy.getAgeInWeeks();
        testGuppy.incrementAge();
        int newAge = testGuppy.getAgeInWeeks();
        assertTrue(newAge == (oldAge + 1));
    }

    @Test
    public void testIncrementAgeKillsGuppyWhenMaxAgeIsReached() {
        testGuppy.setAgeInWeeks(Guppy.MAXIMUM_AGE_IN_WEEKS);
        assertTrue(testGuppy.getIsAlive());
        testGuppy.incrementAge();
        assertFalse(testGuppy.getIsAlive());
    }

    @Test
    public void ageMutatorIgnoresInvalidArguments() {
        int age = zeroParamGuppy.getAgeInWeeks();
        zeroParamGuppy.setAgeInWeeks(-1);
        assertEquals(age, zeroParamGuppy.getAgeInWeeks());

        zeroParamGuppy.setAgeInWeeks(Guppy.MAXIMUM_AGE_IN_WEEKS + 1);
        assertEquals(age, zeroParamGuppy.getAgeInWeeks());
    }

    @Test
    public void ageMutatorAcceptsValidArguments() {
        int age = testGuppy.getAgeInWeeks();
        testGuppy.setAgeInWeeks(0);
        assertEquals(0, testGuppy.getAgeInWeeks());

        testGuppy.setAgeInWeeks(Guppy.MAXIMUM_AGE_IN_WEEKS);
        assertEquals(Guppy.MAXIMUM_AGE_IN_WEEKS, testGuppy.getAgeInWeeks());

        testGuppy.setAgeInWeeks(Guppy.MAXIMUM_AGE_IN_WEEKS - 10);
        assertEquals(Guppy.MAXIMUM_AGE_IN_WEEKS - 10, testGuppy.getAgeInWeeks());
    }

    @Test
    public void healthCoefficientMutatorIgnoresInvalidArguments() {
        double healthCoefficient = zeroParamGuppy.getHealthCoefficient();
        zeroParamGuppy.setHealthCoefficient(-0.01);
        assertEquals(healthCoefficient, zeroParamGuppy.getHealthCoefficient(), 0.0);

        zeroParamGuppy.setHealthCoefficient(1.01);
        assertEquals(healthCoefficient, zeroParamGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void healthCoefficientMutatorAcceptsValidArguments() {
        double healthCoefficient = testGuppy.getHealthCoefficient();

        testGuppy.setHealthCoefficient(1.0);
        assertEquals(1.0, testGuppy.getHealthCoefficient(), 0.0);

        testGuppy.setHealthCoefficient(0.5);
        assertEquals(0.5, testGuppy.getHealthCoefficient(), 0.0);

        /* Thanks Kyrill for finding this bug in our test! */
        testGuppy.setHealthCoefficient(0.0);
        assertEquals(0.0, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void babyFishNeedMinimalVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = 0; i < Guppy.YOUNG_FISH_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            assertEquals(Guppy.MINIMUM_WATER_VOLUME_ML, fry.getVolumeNeeded(), 0.0);
        }
    }

    @Test
    public void youngFishNeedCorrectVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = Guppy.YOUNG_FISH_AGE_IN_WEEKS; i <= Guppy.MATURE_FISH_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            double volumeNeeded = Guppy.MINIMUM_WATER_VOLUME_ML * fry.getAgeInWeeks() / Guppy.YOUNG_FISH_AGE_IN_WEEKS;
            assertEquals(volumeNeeded, fry.getVolumeNeeded(), 0.001);
        }
    }

    @Test
    public void matureFishNeedCorrectVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = Guppy.MATURE_FISH_AGE_IN_WEEKS + 1; i <= Guppy.MAXIMUM_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            double volumeNeeded = Guppy.MINIMUM_WATER_VOLUME_ML * 1.5;
            assertEquals(volumeNeeded, fry.getVolumeNeeded(), 0.001);
        }
    }

    @Test
    public void deadFishNeedNoWater() {
        Guppy fry = new Guppy();
        fry.setAgeInWeeks(50);
        fry.incrementAge();
        assertEquals(0.0, fry.getVolumeNeeded(), 0.0);
    }

    @Test
    public void changeHealthCoefficientWillNotPermitOverlargeHealthCoefficients() {
        testGuppy.changeHealthCoefficient(1.5);
        assertEquals(1.0, testGuppy.getHealthCoefficient(), 0.0);
    }


    @Test
    public void changeHealthCoefficientWillNotPermitNegativeHealthCoefficients() {
        testGuppy.changeHealthCoefficient(-1.5);
        assertEquals(0.0, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void changeHealthCoefficientToZeroOrLowerKillsTheGuppy() {
        testGuppy.changeHealthCoefficient(-1.5);
        assertFalse(testGuppy.getIsAlive());
    }

    /**
     * Test set is alive to false.
     *
     * @author Blake Michalzik
     */
    @Test
    void testSetIsAliveToFalse() {
        // Setup
        testGuppy.setIsAlive(false);

        // Run the test
        final boolean actual = testGuppy.getIsAlive();

        // Verify the results
        assertFalse(actual);
    }

    /**
     * Test set is alive no change from dead.
     *
     * @author Blake Michalzik
     */
    @Test
    void testSetIsAliveNoChangeFromDead() {
        // Setup
        testGuppy.setIsAlive(false); // set alive guppy to dead

        // Run the test
        testGuppy.setIsAlive(true); // try to reanimate the dead!
        final boolean actual = testGuppy.getIsAlive();

        // Verify the results
        assertFalse(actual);
    }

    /**
     * Test set age in weeks with no change is Guppy is dead.
     *
     * @author Blake Michalzik Ryan Leung
     */
    @Test
    void testSetAgeInWeeks_NoChange_IfGuppyDead() {
        // Setup
        final int expected = testGuppy.getAgeInWeeks();
        testGuppy.setIsAlive(false);
        testGuppy.setAgeInWeeks(Guppy.MAXIMUM_AGE_IN_WEEKS);

        // Run the test
        final int actual = testGuppy.getAgeInWeeks();

        // Verify the results
        assertEquals(expected, actual);
    }

    /**
     * Test change health coefficient to zero results guppy death.
     *
     * @author Blake Michalzik
     */
    @Test
    void testChangeHealthCoefficientToZeroResultsGuppyDeath() {
        // Setup
        final double delta = -1.0;

        // Run the test
        testGuppy.changeHealthCoefficient(delta);

        // Verify the results
        assertFalse(testGuppy.getIsAlive());
    }

    /**
     * Test equals is true.
     *
     * @author Blake Michalzik
     */
    @Test
    void testEqualsIsTrue() {
        // Setup
        Guppy secondZeroParamGuppy = new Guppy();

        // Run the test
        final boolean actual = zeroParamGuppy.equals(secondZeroParamGuppy);

        // Verify the results
        assertTrue(actual);
    }

    /**
     * Test equals is false.
     *
     * @author Blake Michalzik
     */
    @Test
    void testEqualsIsFalse() {
        // Setup
        Guppy notEqualGuppyUnderTest = new Guppy("other Genus", "other Species", 12, false, 12, 0.1);

        // Run the test
        final boolean actual = testGuppy.equals(notEqualGuppyUnderTest);

        // Verify the results
        assertFalse(actual);
    }

    /**
     * Test hashCode.
     *
     * @author Blake Michalzik
     */
    @Test
    void testHashCode() {
        // Setup
        final Guppy testGuppy = new Guppy();
        final int expected = testGuppy.hashCode();

        // Run the test
        final int actual = zeroParamGuppy.hashCode();

        // Verify the results
        assertEquals(expected, actual);
    }

    /**
     * Test toString.
     *
     * @author Blake Michalzik
     */
    @Test
    void testToString() {
        // Setup
        Guppy testGuppy = new Guppy();
        final int numberAlreadyCreated = Guppy.getNumberOfGuppiesBorn();
        final String expected = "Guppy{genus='Poecilia', species='reticulata', ageInWeeks=0, " +
                "isFemale=true, generationNumber=0, isAlive=true, healthCoefficient=0.5, " +
                "identificationNumber=" + numberAlreadyCreated + "}";

        // Run the test
        final String actual = testGuppy.toString();

        // Verify the results
        assertEquals(expected, actual);
    }

    /**
     * Test creating a guppy with 0.0 health coefficient is dead.
     *
     * @author Blake Michalzik
     */
    @Test
    public void createGuppyWithZeroHealthCoefficientIsDead() {
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                0,
                Guppy.MINIMUM_HEALTH_COEFFICIENT - 1.0);
        assertFalse(fry.getIsAlive());
    }

    /**
     * Tests that there is a constant FIRST_GENERATION that is int 0.
     *
     * @author Simon Newell
     */
    @Test
    public void containsConstantCalledFIRST_GENERATION() {
        assertEquals(0, Guppy.FIRST_GENERATION);
    }

    /**
     * Tests that the changeHealthCoefficient() method works with a permissible positive value.
     *
     * @author Simon Newell
     */
    @Test
    public void changeHealthCoefficientWillPermitPositiveHealthCoefficients() {
        testGuppy.changeHealthCoefficient(0.05);
        assertEquals(0.8, testGuppy.getHealthCoefficient(), 0.001);
    }

    /**
     * Tests that the changeHealthCoefficient() method works with a permissible negative value.
     *
     * @author Simon Newell
     */
    @Test
    public void changeHealthCoefficientWillPermitNegativeHealthCoefficients() {
        testGuppy.changeHealthCoefficient(-0.05);
        assertEquals(0.7, testGuppy.getHealthCoefficient(), 0.001);
    }

}