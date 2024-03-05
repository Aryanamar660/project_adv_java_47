package employee.annotation;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int e_id;
private String F_name;
private String L_name;
private String e_dept;
private double e_sal;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int e_id, String f_name, String l_name, String e_dept, double e_sal) {
	super();
	this.e_id = e_id;
	F_name = f_name;
	L_name = l_name;
	this.e_dept = e_dept;
	this.e_sal = e_sal;
}
public int getE_id() {
	return e_id;
}
public void setE_id(int e_id) {
	this.e_id = e_id;
}
public String getF_name() {
	return F_name;
}
public void setF_name(String f_name) {
	F_name = f_name;
}
public String getL_name() {
	return L_name;
}
public void setL_name(String l_name) {
	L_name = l_name;
}
public String getE_dept() {
	return e_dept;
}
public void setE_dept(String e_dept) {
	this.e_dept = e_dept;
}
public double getE_sal() {
	return e_sal;
}
public void setE_sal(double e_sal) {
	this.e_sal = e_sal;
}
@Override
public String toString() {
	return "Employee [e_id=" + e_id + ", F_name=" + F_name + ", L_name=" + L_name + ", e_dept=" + e_dept + ", e_sal="
			+ e_sal + "]";
}

}
