package in.org.rebit.visitortracker.service.impl;

import in.org.rebit.visitortracker.dao.VisitorDAO;
import in.org.rebit.visitortracker.entity.Visitor;
import in.org.rebit.visitortracker.exception.VisitorNotFoundException;
import in.org.rebit.visitortracker.service.VisitorService;

import java.util.List;
import java.util.Optional;

public class VisitorServiceImpl implements VisitorService {
    private VisitorDAO dao;

    public VisitorServiceImpl(VisitorDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean saveVisitor(Visitor visitorToVisit) {
        return this.dao.save(visitorToVisit);
    }

    @Override
    public List<Visitor> showAllVisitors() throws VisitorNotFoundException {
        if (!this.dao.showAll().isEmpty()) {
            return this.dao.showAll();
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
        if (o.isPresent()) {
            Visitor foundVisitor = o.get();
            return foundVisitor;
        }
        throw new VisitorNotFoundException("Book with id " + id + " NOT found!");
    }

    @Override
    public Visitor findVisitorByEmail(String email) throws VisitorNotFoundException {
        Optional<Visitor> o = this.dao.findByEmail(email);
        if (o.isPresent()) {
            return o.get();
        }
        throw new VisitorNotFoundException("Book with email " + email + " NOT found!");
    }

    @Override
    public boolean deleteVisitorById(int id){
        return this.dao.deleteVisitor(id);
    }
}
