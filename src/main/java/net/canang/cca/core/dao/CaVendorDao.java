package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaVendor;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaVendorDao {

    CaVendor findById(Long id);

    CaVendor findByCode(String code);

    List<CaVendor> find();

    void save(CaVendor vendor, CaUser user);

    void update(CaVendor vendor, CaUser user);

    void remove(CaVendor vendor, CaUser user);
}
