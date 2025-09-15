package in.org.rebit.visitortracker.dao.impl;

import in.org.rebit.visitortracker.dao.VisitorDAO;
import in.org.rebit.visitortracker.entity.Visitor;

import java.util.*;

public class VisitorDAOImpl implements VisitorDAO {
    private final List<Visitor> visitors;

    public VisitorDAOImpl() {
        this.visitors = new ArrayList<>();
    }

    @Override
    public boolean save(Visitor visitorToVisit) {
        this.visitors.add(visitorToVisit);
        return true;
    }

    @Override
    public List<Visitor> showAll() {
        return this.visitors;
    }

    @Override
    public int countAll() {
        return this.visitors.size();
    }

    @Override
    public Optional<Visitor> findById(int id) {
        for (Visitor foundVisitor: this.visitors) {
            if (foundVisitor != null && foundVisitor.getId() == id) {
                return Optional.of(foundVisitor);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Visitor> findByEmail(String email) {
        for (Visitor foundVisitor: this.visitors) {
            if (foundVisitor != null && foundVisitor.getEmailID().equals(email)) {
                return Optional.of(foundVisitor);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Iterator<Visitor> i = this.visitors.iterator();
        while (i.hasNext()) {
            Visitor nextVisitor = i.next();
            if (nextVisitor.getId() == id) {
                i.remove();
                return true;
            }
        }
        return false;
    }
}
