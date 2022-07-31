package ca.bcit.comp2522.a1;

/**
 * This class describes a guppy.
 * @author Jianfen Deng
 * @version 1.0
 */
public class Guppy {
    /**
     * Young guppy age in weeks is {@value}.
     */
    public static final int     YOUNG_FISH_AGE_IN_WEEKS    = 10;
    /**
     * Mature guppy age in weeks is {@value}.
     */
    public static final int     MATURE_FISH_AGE_IN_WEEKS   = 30;
    /**
     * Maximum guppy age in weeks is {@value}.
     */
    public static final int     MAXIMUM_AGE_IN_WEEKS       = 50;
    /**
     * Minimum water volume in ml is {@value}.
     */
    public static final double  MINIMUM_WATER_VOLUME_ML    = 250.0;
    /**
     * Default genus is known as {@value}.
     */
    public static final String  DEFAULT_GENUS              = "Poecilia";
    /**
     * Default species is known as {@value}.
     */
    public static final String  DEFAULT_SPECIES            = "reticulata";
    /**
     * Default health coefficient is {@value}.
     */
    public static final double  DEFAULT_HEALTH_COEFFICIENT = 0.5;
    /**
     * Minimum health coefficient is {@value}.
     */
    public static final double  MINIMUM_HEALTH_COEFFICIENT = 0.0;
    /**
     * Maximum health coefficient is {@value}.
     */
    public static final double  MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    /**
     * The first generation number is {@value}.
     */
    public static final int     FIRST_GENERATION           = 0;
    private static      int     numberOfGuppiesBorn        = 0;
    private final       String  genus;
    private final       String  species;
    private             int     ageInWeeks;
    private final       int     generationNumber;
    private final       int     identificationNumber;
    private final       boolean isFemale;
    private             boolean isAlive;
    private             double  healthCoefficient;
    /***
     * Initializes a class type Guppy without parameters.
     */
    public Guppy() {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        ageInWeeks           = 0;
        generationNumber     = FIRST_GENERATION;
        genus                = DEFAULT_GENUS;
        species              = DEFAULT_SPECIES;
        isFemale             = true;
        isAlive              = true;
        healthCoefficient    = DEFAULT_HEALTH_COEFFICIENT;
    }
    /***
     * Initializes a class type Guppy with parameters.
     * @param genus guppy genus
     * @param species guppy species
     * @param ageInWeeks guppy age in weeks
     * @param isFemale guppy gender
     * @param generationNum guppy generation number
     * @param healthCoefficient guppy health coefficient
     */
    public Guppy(final String genus, final String species, final int ageInWeeks,
                 final boolean isFemale, final int generationNum,
                 final double healthCoefficient) {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        final int firstIndexOfString  = 0;
        final int secondIndexOfString = 1;
        final int minimumAgeInWeeks   = 0;
        if (genus == null || genus.trim().isEmpty()) {
            this.genus = "Poecilia";
        } else {
            String newGenus = genus.replaceAll("\\s", "");
            this.genus = newGenus.substring(firstIndexOfString, secondIndexOfString).toUpperCase()
                         + newGenus.substring(secondIndexOfString).toLowerCase();
        }
        if (species == null || species.trim().isEmpty()) {
            this.species = "reticulata";
        } else {
            String newSpecies = species.replaceAll("\\s", "");
            this.species = newSpecies.toLowerCase();
        }
        this.generationNumber = Math.max(generationNum, FIRST_GENERATION);
        this.isFemale         = isFemale;
        isAlive               = true;
        if (ageInWeeks < MINIMUM_HEALTH_COEFFICIENT) {
            this.ageInWeeks = minimumAgeInWeeks;
        } else if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = MAXIMUM_AGE_IN_WEEKS;
        } else {
            this.ageInWeeks = ageInWeeks;
        }
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            isAlive = false;
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            this.healthCoefficient = healthCoefficient;
        }
    }
    /**
     * Gets number of guppies born.
     * @return number of guppies born
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }
    /**
     * Gets genus of a guppy.
     * @return guppy genus
     */
    public String getGenus() {
        return genus;
    }
    /**
     * Gets species of a guppy.
     * @return guppy species
     */
    public String getSpecies() {
        return species;
    }
    /**
     * Gets age of a guppy in weeks.
     * @return guppy age in weeks
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }
    /**
     * Gets generation number of a guppy.
     * @return guppy generation number
     */
    public int getGenerationNumber() {
        return generationNumber;
    }
    /**
     * Gets id number of a guppy.
     * @return guppy identification number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }
    /**
     * Gets gender of a guppy.
     * @return guppy gender
     */
    public boolean getIsFemale() {
        return isFemale;
    }
    /**
     * Gets whether a guppy is alive.
     * @return guppy aliveness
     */
    public boolean getIsAlive() {
        return isAlive;
    }
    /**
     * Gets health coefficient of a guppy.
     * @return guppy health coefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }
    /**
     * Sets the age of a guppy in weeks.
     * @param newAgeInWeeks guppy age in weeks
     */
    public void setAgeInWeeks(final int newAgeInWeeks) {
        final int minimumAgeInWeeks = 0;
        if (!getIsAlive()) {
            this.ageInWeeks = getAgeInWeeks();
        } else if (newAgeInWeeks < minimumAgeInWeeks) {
            this.ageInWeeks = minimumAgeInWeeks;
        } else if (newAgeInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = minimumAgeInWeeks;
        } else {
            this.ageInWeeks = newAgeInWeeks;
        }
    }
    /**
     * Sets aliveness of a guppy.
     * @param alive guppy aliveness
     */
    public void setIsAlive(final boolean alive) {
        if (!getIsAlive() && alive) {
            isAlive = getIsAlive();
        } else {
            isAlive = alive;
        }
    }
    /**
     * Sets health coefficient of a guppy.
     * @param healthCoefficient guppy health coefficient
     */
    public void setHealthCoefficient(final double healthCoefficient) {
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            setIsAlive(false);
        }
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT
            || healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        } else {
            this.healthCoefficient = healthCoefficient;
        }
    }
    /**
     * Increases a guppy's age in weeks if a guppy is alive and under maximum age in weeks.
     */
    public void incrementAge() {
        if (isAlive && getAgeInWeeks() <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks++;
        }
        if (getAgeInWeeks() > MAXIMUM_HEALTH_COEFFICIENT) {
            isAlive = false;
        }
    }
    /***
     * Gets water volume in ml that a guppy needs.
     * @return water volume in ml that a guppy needs
     */
    public double getVolumeNeeded() {
        final double valueToFindWaterVolumeForMaturedGuppy = 1.5;
        final double noWaterNeeded                         = 0.0;
        if (getAgeInWeeks() < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (getAgeInWeeks() <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * getAgeInWeeks() / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (getAgeInWeeks() <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * valueToFindWaterVolumeForMaturedGuppy;
        }
        return noWaterNeeded;
    }
    /***
     * Changes guppy health coefficient.
     * @param delta new health coefficient to be added
     */
    public void changeHealthCoefficient(final double delta) {
        healthCoefficient += delta;
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            setIsAlive(false);
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }
    /***
     * Returns a string representation of a guppy object.
     * @return a string representation of a guppy object
     */
    @Override
    public String toString() {
        return "Guppy{"
               + "genus='"
               + genus
               + '\''
               + ", species='"
               + species
               + '\''
               + ", ageInWeeks="
               + ageInWeeks
               + ", isFemale="
               + isFemale
               + ", generationNumber="
               + generationNumber
               + ", isAlive="
               + isAlive
               + ", healthCoefficient="
               + healthCoefficient
               + ", identificationNumber="
               + identificationNumber
               + '}';
    }
    /***
     * Compares two guppy objects.
     * @param o a guppy object
     * @return boolean of whether two guppy objects are equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Guppy)) {
            return false;
        }
        Guppy guppy = (Guppy) o;
        if (getAgeInWeeks() != guppy.getAgeInWeeks()) {
            return false;
        }
        if (getIsFemale() != guppy.getIsFemale()) {
            return false;
        }
        if (getIsAlive() != guppy.getIsAlive()) {
            return false;
        }
        if (Double.compare(guppy.getHealthCoefficient(), getHealthCoefficient()) != 0) {
            return false;
        }
        if (!getGenus().equals(guppy.getGenus())) {
            return false;
        }
        return getSpecies().equals(guppy.getSpecies());
    }
    /***
     * Returns a hashcode of a guppy object based on instance variables.
     * @return a hashcode of a guppy object based on instance variables
     */
    @Override
    public int hashCode() {
        final int valueToFindHashcode1 = 31;
        final int valueToFindHashcode2 = 32;
        final int female               = 1;
        final int male                 = 0;
        final int alive                = 1;
        final int dead                 = 0;
        int       genderValue;
        int       alivenessValue;
        int       result;
        long      temp;
        if (isFemale) {
            genderValue = female;
        } else {
            genderValue = male;
        }
        if (isAlive) {
            alivenessValue = alive;
        } else {
            alivenessValue = dead;
        }
        result = getGenus().hashCode();
        result = valueToFindHashcode1 * result + getSpecies().hashCode();
        result = valueToFindHashcode1 * result + getAgeInWeeks();
        result = valueToFindHashcode1 * result + genderValue;
        result = valueToFindHashcode1 * result + alivenessValue;
        temp   = Double.doubleToLongBits(getHealthCoefficient());
        result = valueToFindHashcode1 * result + (int) (temp ^ (temp >>> valueToFindHashcode2));
        return result;
    }
}
