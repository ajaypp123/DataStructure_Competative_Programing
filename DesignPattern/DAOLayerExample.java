import java.util.*;

// model
class Employee {
    public String name;
    public int id;

    Employee(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}

// interface
interface DAO {
    public HashSet<Employee> getAll();
    public void saveEmployee (Employee r);
}

class DBLayer {
    HashSet<Employee> hs;

    DBLayer() {
        hs = new HashSet<>();
    }

    public HashSet<Employee> getAll() {
        return hs;
    }

    public void saveEmployee(Employee e) {
        hs.add(e);
    }
}

class EmployeeDAOLayer implements DAO {
    DBLayer db;

    EmployeeDAOLayer() {
        db = new DBLayer();
    }

    @Override
    public HashSet<Employee> getAll() {
        return db.getAll();
    }

    @Override
    public void saveEmployee(Employee e) {
        db.saveEmployee(e);
    }
}

class EmployeeAccessLayer {
    EmployeeDAOLayer db;

    EmployeeAccessLayer() {
        db = new EmployeeDAOLayer();
    }

    public HashSet<Employee> getAll() {
        return db.getAll();
    }

    public void saveEmployee(Employee e) {
        db.saveEmployee(e);
    }
}

public class DAOLayerExample {
    public static void main(String[] args) {
        EmployeeAccessLayer ac = new EmployeeAccessLayer();

        ac.saveEmployee(new Employee(1, "A"));
        System.out.println(ac.getAll().toString());
    }
}
