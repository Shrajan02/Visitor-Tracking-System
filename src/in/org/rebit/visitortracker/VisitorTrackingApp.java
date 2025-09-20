package in.org.rebit.visitortracker;

import in.org.rebit.visitortracker.entity.Visitor;
import in.org.rebit.visitortracker.exception.VisitorNotFoundException;
import in.org.rebit.visitortracker.factory.BeanFactory;
import in.org.rebit.visitortracker.service.VisitorService;
import in.org.rebit.visitortracker.util.VisitorUtil;
import in.org.rebit.visitortracker.view.MessageType;
import in.org.rebit.visitortracker.view.VisitorView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VisitorTrackingApp {
    public static void main(String[] args) {
        // using ARM -> resources automatically close after completion
        try (Scanner sc = new Scanner(System.in);
             BeanFactory factory = new BeanFactory();) {
            int choice;
            VisitorView view = new VisitorView();
            VisitorService service = factory.getVisitorService();
            do {
                view.printMenu();
                view.printMessage("Enter your choice = ");
                try {
                    choice = sc.nextInt();
                    switch (choice) {
                        // ADD NEW VISITOR
                        case 1:
                            view.printMessage("Adding a new visitor...", true);
                            view.printMessage("Enter your first name: ");
                            String firstName = sc.next();
                            view.printMessage("Enter your last name: ");
                            String lastName = sc.next();
                            view.printMessage("Enter the person whom you want to visit: ");
                            String visitee = sc.next();
                            view.printMessage("Enter your email: ");
                            String email = sc.next();
                            view.printMessage("Enter your phone number: ");
                            long contactNumber = sc.nextLong();
                            view.printMessage("Enter your purpose: ");
                            String purpose = sc.next();
                            Visitor v1 = new Visitor(firstName, lastName, visitee, email, contactNumber, purpose);
                            boolean isVisited = service.saveVisitor(v1);
                            if (isVisited) {
                                view.printMessage("Visitor details successfully added!", true);
                            }
                            else {
                                view.printMessage("Error! Please add visitor details", true, MessageType.ERROR);
                            }
                            break;

                        // SHOW ALL VISITORS DETAILS
                        case 2:
                            try {
                                List<Visitor> allVisitors = service.showAllVisitors();
                                view.printVisitors(allVisitors);
                            }
                            catch (VisitorNotFoundException e) {
                                view.printMessage("Error: " + e.getMessage(), true, MessageType.ERROR);
                            }
                            break;

                        // COUNT TOTAL VISITORS
                        case 3:
                            view.printMessage("Total visitors = " + service.countAllVisitors(), true);
                            break;

                        // FIND VISITOR BY ID
                        case 4:
                            view.printMessage("Enter the visitor ID to find = ");
                            int idToFind = sc.nextInt();
                            try {
                                Visitor foundVisitor = service.findVisitorById(idToFind);
                                view.printVisitor(foundVisitor);
                            }
                            catch (VisitorNotFoundException e) {
                                view.printMessage("Error: " + e.getMessage(), true, MessageType.ERROR);
                            }
                            break;

                        // FIND VISITOR BY EMAIL
                        case 5:
                            view.printMessage("Enter the visitor email to find: ");
                            String emailToFind = sc.next();
                            try {
                                Visitor foundVisitor = service.findVisitorByEmail(emailToFind);
                                view.printVisitor(foundVisitor);
                            }
                            catch (VisitorNotFoundException e) {
                                view.printMessage("Error: " + e.getMessage(), true, MessageType.ERROR);
                            }
                            break;

                        // DELETE VISITOR BY ID
                        case 6:
                            view.printMessage("Enter the visitor ID to delete = ");
                            int id = sc.nextInt();
                            boolean visitorToBeDeleted = service.deleteVisitor(id);
                            if (visitorToBeDeleted) {
                                view.printMessage("Visitor " + id + " details deleted successfully!", true);
                            }
                            else {
                                view.printMessage("Error! No visitor details found!", true, MessageType.ERROR);
                            }
                            break;

                        // SEARCH VISITORS BY WHOM THEY WANT TO MEET
                        case 7:
                            view.printMessage("Enter the person whom visitors went to meet = ");
                            String visiteeToMeet = sc.next();
                            try {
                                List<Visitor> allVisitors = service.showAllVisitors();
                                List<Visitor> searchedVisitors = VisitorUtil.searchVisitorsByCriteria(allVisitors, p -> p.getVisitee().equals(visiteeToMeet));
                                view.printVisitors(searchedVisitors);
                            }
                            catch (VisitorNotFoundException e) {
                                view.printMessage("Error: " + e.getMessage(), true, MessageType.ERROR);
                            }
                            break;

                        // COUNT VISITORS WHOSE NAME STARTS WITH
                        case 8:
                            view.printMessage("Enter the letter you want the visitor's name to start with = ");
                            String nameStartsWith = sc.next();
                            try {
                                List<Visitor> allVisitors = service.showAllVisitors();
                                int countSearchedVisitors = VisitorUtil.countVisitorsByCriteria(allVisitors, p -> p.getFirstName().startsWith(nameStartsWith));
                                view.printMessage("Total visitors whose name starts with " + nameStartsWith + " = " + countSearchedVisitors, true);
                            }
                            catch (VisitorNotFoundException e) {
                                view.printMessage("Error: " + e.getMessage(), true, MessageType.ERROR);
                            }
                            break;
                         // EXIT
                        case -1:
                            view.printMessage("Thank you for checking visitor details!", true);
                            break;

                        // INVALID CHOICE
                        default:
                            view.printMessage("Invalid choice! Please check the menu", true, MessageType.ERROR);
                    }
                }
                catch (InputMismatchException e) {
                    view.printMessage("Please enter INTEGER values only!", true, MessageType.ERROR);
                    sc.next();
                    choice = 0;
                }
            } while (choice != -1);
        }
    }
}
