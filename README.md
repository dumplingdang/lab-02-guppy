# lab-02-guppy
You have been hired to generate some helpful software for a group of ichthyologists at the Vancouver Aquarium. A new and invasive species of Poecilia, the live-bearing aquarium fish also known as the guppy,
has been discovered in some of the hot springs, pools, and streams near Skookumchuk. The owners of the land have asked the scientists to study the prolific little fish and determine, among other things, if its
reproductive rate will be a threat to native aquatic fauna.
## Implementation requirements
You must implement a class called **Guppy.java** which contains the following elements:
1. The following nine public symbolic constants. Use these variable names and data types. In Java, symbolic constants are static and final. Do not use different names or data types, and do not add
any other symbolic constants. Use these constants instead of magic numbers inside your code:
    - **YOUNG_FISH_AGE_IN_WEEKS** an integer equal to 10
    - **MATURE_FISH_AGE_IN_WEEKS** an integer equal to 30
    - **MAXIMUM_AGE_IN_WEEKS** an integer equal to 50
    - **MINIMUM_WATER_VOLUME_ML** a double equal to 250.0
    - **DEFAULT_GENUS** a String equal to “Poecilia"
    - **DEFAULT_SPECIES** a String equal to “reticulata"
    - **DEFAULT_HEALTH_COEFFICIENT** a double equal to 0.5
    - **MINIMUM_HEALTH_COEFFICIENT** a double equal to 0.0
    - **MAXIMUM_HEALTH_COEFFICIENT** a double equal to 1.0
2. The following eight private instance variables. Use these variable names and data types. Do not use different names or data types, and do not add any other instance variables:
    - **genus** (first word of the scientific binomial two-part name) a String
    - **species** (second word of the scientific binomial name) a String
    - **ageInWeeks** an integer
    - **isFemale** a boolean
    - **generationNumber** an integer
    - **isAlive** a boolean
    - **healthCoefficient** a double
    - **identificationNumber** an integer
3. **numberOfGuppiesBorn**, a private static integer that has an initial value of 0. This variable is incrementedby 1 each time a new guppy is constructed, and the newly incremented value is assigned
to the new guppy’s **identificationNumber** instance variable. Further details are provided in thesection about constructors (remember that static variables are shared by all objects of a class).
4. Two (2) constructors:
    - A zero-parameter constructor which sets ageInWeeks and generationNumber to zero, and sets:
        - **genus** to **DEFAULT_GENUS**
        - **species** to **DEFAULT_SPECIES**
        - **isFemale** to true
        - **isAlive** to true
        - **healthCoefficient** to **DEFAULT_HEALTH_COEFFICIENT**
        - **identificationNumber** to the newly incremented value of **numberOfGuppiesBorn**
    - A second constructor which accepts the following parameters in the following order:
        - **newGenus** a String. Format the String passed in **newGenus** correctly (capital first letter, the rest lower case) and assign the new String to the **genus** instance variable.
        - **newSpecies** a String. Format the String passed in **newSpecies** correctly (lower case) and assign the new String to the **species** instance variable.
        - **newAgeInWeeks** a positive integer. Assign **newAgeInWeeks** to the **ageInWeeks** instance variable. If the parameter passed to the method is negative, assign a 0.
        - **newIsFemale** a boolean to assign to the **isFemale** instance variable.
        - **newGenerationNumber** an integer. If the argument passed as the parameter is less than zero, set the value to zero. Otherwise assign **newGenerationNumber** to the **generationNumber** instance variable.
        - **newHealthCoefficient** a double. If the argument passed as the parameter is less than **MINIMUM_HEALTH_COEFFICIENT** or greater than **MAXIMUM_HEALTH_COEFFICIENT**, set the value to the closest bound. Otherwise assign **newHealthCoefficient** to the instance variable called **healthCoefficient**.
        - This constructor should not accept a parameter for the **isAlive** instance variable. Set the **isAlive** variable to true. Every new **Guppy** is alive by default.
    - Remember that each constructor must also increment the static **numberOfGuppiesBorn** variable by 1 and and assign the new value to **identificationNumber**.
5. A method with the header public void **incrementAge()** which increases the value in the ageInWeeks instance variable field by 1. If the new value in **ageInWeeks** is greater than **MAXIMUM_AGE_IN_WEEKS**,
set the **isAlive** instance variable to false.
6. An accessor (getter) for all eight instance variables, and amutator (setter) for **ageInWeeks**, **isAlive**, and **healthCoefficient**:
    - Do not create mutators for **genus**, **species**, **isFemale**, or **identificationNumber**.
    - Every accessor method name must follow the pattern **getVariableName**.
    - Every mutator method name must follow the pattern **setVariableName**.
    - Also create a static accessor for the **numberOfGuppiesBorn** static variable. It must be called public static int **getNumberOfGuppiesBorn()**.
    - The mutator for **ageInWeeks** must ignore values below 0 and above **MAXIMUM_AGE_IN_WEEKS**.
    - The mutator for **isAlive** must ignore values that would create zombie Guppies, i.e., once a Guppy dies, it must not be reanimated. This is science, not science fiction!
    - The mutator for **healthCoefficient** must ignore values that would cause the **healthCoefficient** variable to exceed its bounds.
7. A method with the header public double **getVolumeNeeded()** which returns the volume of water in millilitres that the guppy needs according to the following formula:
    - If the fish is less than 10 weeks old, return **MINIMUM_WATER_VOLUME_ML**.
    - If the fish is 10 to 3 0weeks old, return **MINIMUM_WATER_VOLUME_ML** * **ageInWeeks** / **YOUNG_FISH_WEEKS**.
    - If the fish is 31 to 50 weeks old, return **MINIMUM_WATER_VOLUME_ML** * 1.5.
    - If the fish is older than 50 weeks, return 0.0.
8. a method with the header public void **changeHealthCoefficient** (double delta) which adds the value passed in the delta parameter to the **healthCoefficient** instance variable. The parameter
delta may be positive or negative, but if the new value of **healthCoefficient** would be less than or equal to **MINIMUM_HEALTH_COEFFICIENT**, in addition to setting the value of **healthCoefficient**
to 0.0, set the **isAlive** instance variable to false. If the new value of **healthCoefficient** would be greater than **MAXIMUM_HEALTH_COEFFICIENT**, set **healthCoefficient** to **MAXIMUM_HEALTH_COEFFICIENT**.
9. a method with the header public String **toString()** which returns a String representation of the guppy. The version generated by IntelliJ is sufficient.
10. an **equals()** method and a **hashCode()** method. When we compare Guppies for equality, we don’t want to consider ID number or generation number. We will only consider their physical attributes.
