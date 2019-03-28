package ro.msg.learning.odata.core;

import org.apache.olingo.odata2.api.edm.*;
import org.apache.olingo.odata2.api.edm.provider.*;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoreEdmProvider extends EdmProvider {

    private static final String NAMESPACE = "Shop";

    public static final String ENTITY_SET_ORDER_TO = "Orders";

    public static final String ENTITY_SET_PRODUCT = "Products";

    public static final String ENTITY_ORDER_TO = "Order";

    public static final String ENTITY_PRODUCT = "Product";

    private static final String ENTITY_CONTAINER = "ShopEntityContainer";

    private static final FullQualifiedName ORDER_TO = new FullQualifiedName(NAMESPACE, ENTITY_ORDER_TO);

    private static final FullQualifiedName PRODUCT = new FullQualifiedName(NAMESPACE, ENTITY_PRODUCT);

    private static final FullQualifiedName ASSOCIATION_ORDER_PRODUCT = new FullQualifiedName(NAMESPACE, "Order_Product_Product_Order");

    private static final String ROLE_ORDER_PRODUCT = "Order_Product";

    private static final String ROLE_PRODUCT_ORDER = "Product_Order";

    private static final String ORDER_PRODUCTS_ASSOCIATION_SET = "Order_Products";

    @Override
    public List<Schema> getSchemas() throws ODataException {

        List<Schema> schemas = new ArrayList<>();

        Schema schema = new Schema();
        schema.setNamespace(NAMESPACE);

        List<EntityType> entityTypes = new ArrayList<>();

        entityTypes.add(getEntityType(ORDER_TO));
        entityTypes.add(getEntityType(PRODUCT));
        schema.setEntityTypes(entityTypes);

        List<EntityContainer> entityContainers = new ArrayList<>();
        EntityContainer entityContainer = new EntityContainer();
        entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);

        List<EntitySet> entitySets = new ArrayList<>();
        entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_ORDER_TO));
        entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_PRODUCT));
        entityContainer.setEntitySets(entitySets);

        List<Association> associations = new ArrayList<>();
        associations.add(getAssociation(ASSOCIATION_ORDER_PRODUCT));
        schema.setAssociations(associations);

        List<AssociationSet> associationSets = new ArrayList<>();
        associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_ORDER_PRODUCT, ENTITY_SET_ORDER_TO, ROLE_ORDER_PRODUCT));
        entityContainer.setAssociationSets(associationSets);

        entityContainers.add(entityContainer);
        schema.setEntityContainers(entityContainers);

        schemas.add(schema);

        return schemas;
    }

    @Override
    public EntityType getEntityType(FullQualifiedName edmFQName) throws ODataException {

        if (NAMESPACE.equals(edmFQName.getNamespace())) {

            if (ORDER_TO.getName().equals(edmFQName.getName())) {

                //Properties
                List<Property> properties = new ArrayList<>();

                properties.add(new SimpleProperty().setName("OrderId").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets()));
                properties.add(new SimpleProperty().setName("Date").setType(EdmSimpleTypeKind.DateTime)
                        .setFacets(new Facets().setNullable(true).setConcurrencyMode(EdmConcurrencyMode.Fixed))
                        .setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_UPDATED)));
                properties.add(new SimpleProperty().setName("Country").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)
                        .setMaxLength(100)).setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));
                properties.add(new SimpleProperty().setName("City").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)
                        .setMaxLength(100)).setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));
                properties.add(new SimpleProperty().setName("County").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)
                        .setMaxLength(100)).setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));
                properties.add(new SimpleProperty().setName("StreetAddress").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)
                        .setMaxLength(200)).setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));

                properties.add(new SimpleProperty().setName("StreetAddress").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)
                        .setMaxLength(200)).setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));

                //Key
                List<PropertyRef> keyProperties = new ArrayList<>();
                keyProperties.add(new PropertyRef().setName("OrderId"));
                Key key = new Key().setKeys(keyProperties);

                //Navigation Properties
                List<NavigationProperty> navigationProperties = new ArrayList<>();
                navigationProperties.add(new NavigationProperty().setName(ENTITY_PRODUCT)
                        .setRelationship(ASSOCIATION_ORDER_PRODUCT).setFromRole(ROLE_ORDER_PRODUCT).setToRole(ROLE_PRODUCT_ORDER));

                return new EntityType().setName(ORDER_TO.getName()).setKey(key)
                        .setProperties(properties).setNavigationProperties(navigationProperties);

            } else if (PRODUCT.getName().equals(edmFQName.getName())) {

                //Properties
                List<Property> properties = new ArrayList<>();

                properties.add(new SimpleProperty().setName("ProductId").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets()));
                properties.add(new SimpleProperty().setName("Quantity").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets()));

                //Key
                List<PropertyRef> keyProperties = new ArrayList<>();
                keyProperties.add(new PropertyRef().setName("ProductId"));
                Key key = new Key().setKeys(keyProperties);

                return new EntityType().setName(PRODUCT.getName()).setKey(key)
                        .setProperties(properties);
            }
        }
        return null;
    }

    @Override
    public Association getAssociation(FullQualifiedName edmFQName) throws ODataException {

        if (NAMESPACE.equals(edmFQName.getNamespace()) && ASSOCIATION_ORDER_PRODUCT.getName().equals(edmFQName.getName())) {

            return new Association().setName(ASSOCIATION_ORDER_PRODUCT.getName())
                    .setEnd1(new AssociationEnd().setType(ORDER_TO).setRole(ROLE_ORDER_PRODUCT).setMultiplicity(EdmMultiplicity.ONE))
                    .setEnd2(new AssociationEnd().setType(PRODUCT).setRole(ROLE_PRODUCT_ORDER).setMultiplicity(EdmMultiplicity.MANY));
        }
        return null;
    }


    @Override
    public EntitySet getEntitySet(String entityContainer, String name) throws ODataException {

        if (ENTITY_CONTAINER.equals(entityContainer)) {
            if (ENTITY_SET_ORDER_TO.equals(name)) {
                return new EntitySet().setName(name).setEntityType(ORDER_TO);
            } else if (ENTITY_SET_PRODUCT.equals(name)) {
                return new EntitySet().setName(name).setEntityType(PRODUCT);
            }
        }
        return null;
    }

    @Override
    public AssociationSet getAssociationSet(String entityContainer, FullQualifiedName association, String sourceEntitySetName, String sourceEntitySetRole) throws ODataException {
        if (ENTITY_CONTAINER.equals(entityContainer) && ASSOCIATION_ORDER_PRODUCT.equals(association)) {
            return new AssociationSet().setName(ORDER_PRODUCTS_ASSOCIATION_SET)
                    .setAssociation(ASSOCIATION_ORDER_PRODUCT)
                    .setEnd1(new AssociationSetEnd().setRole(ROLE_ORDER_PRODUCT).setEntitySet(ENTITY_SET_ORDER_TO))
                    .setEnd2(new AssociationSetEnd().setRole(ROLE_PRODUCT_ORDER).setEntitySet(ENTITY_SET_PRODUCT));
        }
        return null;
    }

    @Override
    public EntityContainerInfo getEntityContainerInfo(String name) throws ODataException {
        if (name == null || ENTITY_CONTAINER.equals(name)) {
            return new EntityContainerInfo().setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);
        }

        return null;
    }
}