package net.canang.cca.web.client;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountModel implements Serializable {

    public static interface AccountProperties extends PropertyAccess<AccountModel> {
        @Editor.Path("id")
        ModelKeyProvider<AccountModel> id();

        ValueProvider<AccountModel, String> code();

        ValueProvider<AccountModel, String> description();

        ValueProvider<AccountModel, String> alias();
    }

    private Long id;
    private String code;
    private String description;
    private String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
