package kaskelas.dao;

import java.util.List;
import kaskelas.model.Kas;

public interface kasDAO {

    List<Kas> get();

    boolean save(Kas kas);

    Kas getSinggle(int id);

    boolean update(Kas kas);

    boolean delete(int id);
}
