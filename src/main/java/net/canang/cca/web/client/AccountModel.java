package net.canang.cca.web.client;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 6/3/13
 */
public class AccountModel implements Serializable {

    public static class MyLabelProvider implements LabelProvider<AccountModel> {
        @Override
        public String getLabel(AccountModel item) {
            return item.getCode();
        }
    }

    public static class MyKeyProvider implements ModelKeyProvider<AccountModel> {
        @Override
        public String getKey(AccountModel item) {
            return item.getId().toString();
        }
    }

    public static interface AccountLabels extends LabelProvider<AccountModel> {

        LabelProvider<AccountModel> id();

        LabelProvider<AccountModel> code();

        LabelProvider<AccountModel> description();

        LabelProvider<AccountModel> alias();
    }

    public static interface XModelKeyProvider<AccountModel> extends ModelKeyProvider<AccountModel> {
    }

    public static interface AccountProperties extends PropertyAccess<AccountModel> {
        @Editor.Path("id")
        ModelKeyProvider<AccountModel> id();

        @Editor.Path("code")
        ValueProvider<AccountModel, String> code();

        @Editor.Path("description")
        ValueProvider<AccountModel, String> description();

        @Editor.Path("alias")
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
