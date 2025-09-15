package in.org.rebit.visitortracker.util;

import in.org.rebit.visitortracker.entity.Visitor;

import java.util.List;
import java.util.function.Predicate;

public class VisitorUtil {
    public static List<Visitor> searchVisitorsByCriteria(List<Visitor> visitors, Predicate<Visitor> visitorPredicate) {
        return visitors.stream()
                .filter(visitorPredicate)
                .toList();
    }

    public static int countVisitorsByCriteria(List<Visitor> visitors, Predicate<Visitor> visitorPredicate) {
        return visitors.stream()
                .filter(visitorPredicate)
                .toList()
                .size();
    }
}
