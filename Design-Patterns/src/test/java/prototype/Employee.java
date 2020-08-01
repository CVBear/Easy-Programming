package prototype;

class Employee // simplified Employee class
{
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   private String name;
   private double salary;
}