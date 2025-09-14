package in.org.rebit.visitortracker.dao;

import in.org.rebit.visitortracker.entity.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorDAO {
    boolean save(Visitor visitorToVisit);

    List<Visitor> showAll();

    int countAll();

    Optional<Visitor> findById(int id);

    Optional<Visitor> findByEmail(String email);

    boolean delete(int id);
}
