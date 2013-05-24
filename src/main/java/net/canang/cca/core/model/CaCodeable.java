package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaCodeable {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    String getAlias();

    void setAlias(String alias);
}
