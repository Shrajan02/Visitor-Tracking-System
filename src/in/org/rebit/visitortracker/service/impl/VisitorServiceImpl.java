package in.org.rebit.visitortracker.service.impl;

import in.org.rebit.visitortracker.dao.VisitorDAO;
import in.org.rebit.visitortracker.entity.Visitor;
import in.org.rebit.visitortracker.exception.VisitorNotFoundException;
import in.org.rebit.visitortracker.service.VisitorService;

import java.util.List;
import java.util.Optional;

public class VisitorServiceImpl implements VisitorService {
    private final VisitorDAO dao;

    // constructor injection
    public VisitorServiceImpl(VisitorDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean saveVisitor(Visitor visitorToVisit) {
        return this.dao.save(visitorToVisit);
    }

    @Override
    public List<Visitor> showAllVisitors() throws VisitorNotFoundException {
        List<Visitor> visitors = this.dao.showAll();
        if (!visitors.isEmpty()) {
            return visitors;
        }
        throw new VisitorNotFoundException("No visitor details found! Add visitor details");
    }

    @Override
    public int countAllVisitors() {
        return this.dao.countAll();
    }

    @Override
    public Visitor findVisitorById(int id) throws VisitorNotFoundException {
        Optional<Visitor> o = this.dao.findById(id);
        Visitor visitor = o.orElseThrow(() -> new VisitorNotFoundException("Visitor with id " + id + " NOT found!"));
        return visitor;
        /*
        if (o.isPresent()) {
            Visitor foundVisitor = o.get();
            return foundVisitor;
        }
        throw new VisitorNotFoundException("Visitor with id " + id + " NOT found!");
         */
    }

    @Override
    public Visitor findVisitorByEmail(String email) throws VisitorNotFoundException {
        Optional<Visitor> o = this.dao.findByEmail(email);
        return o.orElseThrow(() -> new VisitorNotFoundException("Visitor with email " + email + " NOT found!"));
    }

    @Override
    public boolean deleteVisitor(int id){
        return this.dao.delete(id);
    }
}
