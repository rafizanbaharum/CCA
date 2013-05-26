package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/26/13
 */
public interface CaConfiguration extends CaMetaObject {

    String getKey();

    void setKey(String key);

    String getValue();

    void setValue(String value);
}
