

class Request {
    public String name;
    Request(String name) {
        this.name = name;
    }
}

interface IModel {

}

interface IView {
    public void display(Object o);
}

interface IController {
    public Employee create(Request r);
    public void display(Object o);
}

// Model
class Employee implements IModel {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public static Employee create(Request r) {
        return new Employee(r.name);
    }

    public String getName() {
        return name;
    }
}

// View
class StringEmployeeView implements IView {
    @Override
    public void display(Object o) {
        System.out.println(((Employee)o).name);
    }
}

// Controller
class EmployeeController implements IController {
    IView view;

    EmployeeController(IView view) {
        this.view = view;
    }

    @Override
    public Employee create(Request r) {
        return Employee.create(r);
    }

    @Override
    public void display(Object o) {
        view.display((Employee)o);
    }
}

public class MVCExample {
    public static void main(String[] args) {

        IController controller = new EmployeeController(new StringEmployeeView());
        Request r = new Request("A");

        Employee e = controller.create(r);
        controller.display(e);
    }
}
