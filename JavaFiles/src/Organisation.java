class Employee {
	int salary;
	Employee(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return this.salary;
	}
}


class Manager extends Employee {
	int incentive;
	Manager(int salary, int incentive) {
		super(salary);
		this.incentive = incentive;
	}

	@Override
	public int getSalary() {
		return super.getSalary() + this.incentive;
	}
}

class Labour extends Employee {
	int overtime;
	Labour(int salary, int overtime) {
		super(salary);
		this.overtime = overtime;
	}

	@Override
	public int getSalary() {
		return super.getSalary() + this.overtime;
	}
}


public class Organisation {
	public static int getTotalSalary(Employee ... emps) {
		int salary = 0;
		for (Employee e : emps) {
			salary += e.getSalary();
		}
		return salary;
	}
	
	public static void main(String[] args) {	
		Employee mayur = new Manager(5000, 1200);
		Employee shubh = new Labour(500, 50);
		Employee[] emps = new Employee[2];
		emps[0] = mayur;
		emps[1] = shubh;
		System.out.println(mayur.getSalary());
		System.out.println(shubh.getSalary());
		System.out.println("Total : " + getTotalSalary(mayur, shubh));
	}
}