package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaUser;
import net.canang.cca.core.model.CaConsumer;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaConsumerDao {

    CaConsumer findById(Long id);

    CaConsumer findByCode(String code);

    List<CaConsumer> find();

    void save(CaConsumer vendor, CaUser user);

    void update(CaConsumer vendor, CaUser user);

    void remove(CaConsumer vendor, CaUser user);
}
