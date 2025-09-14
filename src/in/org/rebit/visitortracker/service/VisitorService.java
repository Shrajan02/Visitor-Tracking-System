package in.org.rebit.visitortracker.service;

import in.org.rebit.visitortracker.entity.Visitor;
import in.org.rebit.visitortracker.exception.VisitorNotFoundException;

import java.util.List;

public interface VisitorService {
    boolean saveVisitor(Visitor visitorToVisit);

    List<Visitor> showAllVisitors() throws VisitorNotFoundException;

    int countAllVisitors();

    Visitor findVisitorById(int id) throws VisitorNotFoundException;

    Visitor findVisitorByEmail(String email) throws VisitorNotFoundException;

    boolean deleteVisitorById(int id);
}
