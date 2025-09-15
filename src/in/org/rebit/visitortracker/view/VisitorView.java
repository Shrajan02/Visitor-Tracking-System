package in.org.rebit.visitortracker.view;

import in.org.rebit.visitortracker.entity.Visitor;

import java.util.List;

public class VisitorView {
    public void printMessage (String message){
        System.out.print(message);
    }

    public void printMessage (String message, boolean addLine) {
        if (addLine) {
            System.out.println(message);
        }
    }

    public void printMessage (String message, boolean addLine, MessageType messageType) {
        if (messageType == MessageType.SUCCESS) {
            printMessage(message, addLine);
        }
        else {
            System.err.println(message);
        }
    }

    public void printMenu () {
        String menu = """
                    1. ADD NEW VISITOR
                    2. DISPLAY ALL VISITOR DETAILS
                    3. COUNT OF TOTAL VISITORS
                    4. FIND VISITOR BY ID
                    5. FIND VISITOR BY EMAIL
                    6. DELETE VISITOR
                    -1. EXIT
                """;

        printMessage(menu);
    }

    public void printVisitor(Visitor v)
    {
        printMessage(v.getId() + "\t" + v.getFirstName() + "\t" + v.getLastName()+"\t"+v.getVisitee() + "\t" + v.getEmailID() + "\t" + v.getContactNumber() + "\t" + v.getPurpose() + "\n");
    }

    public void printVisitors(List<Visitor> allVisitors)
    {
        showHeader();
        allVisitors.forEach(System.out::println);  // using method reference
        /*
          for (Visitor v : allVisitors) {
             printVisitor(v);
          }
        */
    }

    private void showHeader()
    {
        printMessage("=================================================================================\n");
        printMessage("Visitor ID \t First Name \t Last Name \t Visitee \t Email \t Phone No \t Purpose\n");
        printMessage("=================================================================================\n");
    }

}
