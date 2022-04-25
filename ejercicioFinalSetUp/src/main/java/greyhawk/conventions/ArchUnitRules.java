package greyhawk.conventions;

import org.greyhawk.archunit.GenericRules;
import org.greyhawk.archunit.LayersCustomizations;
import org.greyhawk.archunit.LayersRules;
import org.greyhawk.archunit.SpringRules;
import org.greyhawk.archunit.layers.LayersAccessRules;
import org.greyhawk.archunit.layers.LayersComponentRules;
import org.greyhawk.archunit.layers.LayersModelRules;
import com.tngtech.archunit.lang.ArchRule;

public class ArchUnitRules {

    // generic
    public static final ArchRule JAVA_UTIL_LOGGING = GenericRules.NO_JAVA_UTIL_LOGGING;
    public static final ArchRule STANDARD_STREAMS = GenericRules.NO_STANDARD_STREAMS;
    public static final ArchRule JODATIME = GenericRules.NO_JODATIME;
    public static final ArchRule NO_CYCLES = GenericRules.NO_CYCLES;

    // spring

    public static final ArchRule AUTOWIRED_FIELDS = SpringRules.NO_AUTOWIRED_IN_FIELDS;
    public static final ArchRule AUTOWIRED_METHODS = SpringRules.NO_AUTOWIRED_IN_METHODS;
    public static final ArchRule AUTOWIRED_CONSTRUCTORS = SpringRules.NO_AUTOWIRED_IN_CONSTRUCTORS;
    public static final ArchRule AUTOWIRED_PARAMS = SpringRules.NO_AUTOWIRED_IN_PARAMS;

    public static final ArchRule VALUE_METHODS = SpringRules.NO_VALUE_IN_METHODS;
    public static final ArchRule VALUE_CONSTRUCTORS = SpringRules.NO_VALUE_IN_CONSTRUCTORS;
    public static final ArchRule VALUE_PROPS = SpringRules.VALUE_IN_PROPS;

    public static final ArchRule PROPERTIES_UBICATION = SpringRules.PROPERTIES_UBICATION;

    public static final ArchRule CONFIG_UBICATION = SpringRules.CONFIG_UBICATION;
    public static final ArchRule CONFIGURATION_IN_CONFIG = SpringRules.CONFIGURATION_IN_CONFIG;

    public static final ArchRule BEANS_IN_CONFIG = SpringRules.BEANS_IN_CONFIG;
    public static final ArchRule BEANS_WITH_CONFIGURATION = SpringRules.BEANS_WITH_CONFIGURATION;

    public static final ArchRule APPLICATION_IN_APPL = SpringRules.APPLICATION_IN_APPL;

    public static final ArchRule MAPPERS_UBICATION = SpringRules.MAPPERS_UBICATION;
    public static final ArchRule MAPPERS_IN_MAPPERS = SpringRules.MAPPERS_IN_MAPPERS;

    // layers
    private final LayersCustomizations customizations = LayersCustomizations.builder()
            .useCommonsPackage(LayersCustomizations.Usage.OPTL)
            .useDomainConnectors(LayersCustomizations.Usage.OPTL)
            .useDomainConnectorsPackage(LayersCustomizations.Usage.OPTL)
            .useDomainConnectors(LayersCustomizations.Usage.OPTL)
            .useOutboundConnectorsPackage(LayersCustomizations.Usage.OPTL)
            .build();
    private final LayersRules layers = new LayersRules(customizations);

    private final LayersComponentRules components = layers.componentsRules();
    public final ArchRule controllers = components.controllersUbication();
    public final ArchRule services = components.servicesUbication();
    public final ArchRule repositories = components.repositoriesUbication();
    public final ArchRule autoconfig = components.autoconfigUbication();
    public final ArchRule application = components.applicationUbication();

}