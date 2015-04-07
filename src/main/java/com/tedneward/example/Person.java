package assignment;

import java.beans.*;
import java.util.*;
import java.lang.IllegalArgumentException;
import java.util.Comparator;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  public static int counter = 0;
  
  public static class AgeComparator implements Comparator<Person>{
	  public int compare(Person p1, Person p2){
		  return p1.getAge() - p2.getAge();
	  }
  }
  
  public static int count(){
	  return counter;
  }

  public int compareTo(Person other){
	 return (int)(other.getSalary() - this.getSalary());
  }
  
  public static ArrayList<Person> getNewardFamily(){
	  final Person p1 = new Person("Ted",41,250000);
	  final Person p2 = new Person("Charlotte",43,150000);
	  final Person p3 = new Person("Michael",22,10000);
	  final Person p4 = new Person("Matthew",15,0);
	  return new ArrayList<Person>(){{add(p1);add(p2);add(p3);add(p4);}};
  }
  
  public Person() {
    this("", 0, 0.0d);
    counter++;
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
  }

  public int getAge() {
    return age;
  }
  
  public void setAge(int a){
		 if (a < 0){
			 throw new IllegalArgumentException("Age cannot be under 0.");
		 }
	this.age = a; 
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String s){
		  if (s == null){
			  throw new IllegalArgumentException("Please set a name.");
		  }
	  this.name = s;
  }
  
  public double getSalary() {
    return salary;
  }
  
  public void setSalary(Double a){
	  if (a < 0){
		  throw new IllegalArgumentException("Salary cannot be under 0.");
	  }
	  this.salary = a;
  }
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    //pcs.firePropertyChange(new PropertyChangeEvent(this, "ssn", old, value));
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Object p) {
	  if (p instanceof Person){
		  Person p1 = (Person)p;
		  return (this.name.equals(p1.name) && this.age == p1.age);
	  }
    return false;
  }

  public String toString() {
    return "[Person name:" + this.getName() + " age:" + this.getAge() + " salary:" + this.getSalary() + "]";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
