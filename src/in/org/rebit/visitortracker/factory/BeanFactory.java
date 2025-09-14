package in.org.rebit.visitortracker.factory;

import in.org.rebit.visitortracker.dao.VisitorDAO;
import in.org.rebit.visitortracker.dao.impl.VisitorDAOImpl;
import in.org.rebit.visitortracker.service.VisitorService;
import in.org.rebit.visitortracker.service.impl.VisitorServiceImpl;

public class BeanFactory {
    public VisitorDAO getVisitorDAO(){
        VisitorDAO dao = new VisitorDAOImpl();
        return dao;
    }

    public VisitorService getVisitorService()
    {
        VisitorService service = new VisitorServiceImpl(getVisitorDAO());
        return service;
    }
}
