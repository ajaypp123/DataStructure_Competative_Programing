
interface Iterator {
    public boolean hasNext();
    public Object getNext();
}

class GenericIterator implements Iterator {
    Object[] obj;
    int total = 0;
    int current;

    GenericIterator() {
        obj = new Object[20];
        current = 0;
        total = 0;
    }

    public void setNext(Object o) {
        this.obj[total] = o;
        total++;
    }

    @Override
    public boolean hasNext() {
        if(current < total) {
            return true;
        }
        return false;
    }

    @Override
    public Object getNext() {
        Object o = obj[current];
        current++;
        return o;
    }
}

class EmployeeRepository {
    GenericIterator itr;

    EmployeeRepository() {
        itr = new GenericIterator();
    }

    public void add(Employee e) {
        itr.setNext(e);
    }

    public void printRepo() {
        while(itr.hasNext()) {
            Employee obj = ((Employee)itr.getNext());
            System.out.println(obj.name);
        }
    }

}

class Employee {
    public String name;
    Employee(String name) {
        this.name = name;
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        EmployeeRepository er = new EmployeeRepository();
        er.add(new Employee("a"));
        er.add(new Employee("b"));
        er.add(new Employee("c"));

        er.printRepo();
    }
}
