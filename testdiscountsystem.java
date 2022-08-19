
// import javax.xml.crypto.Data;
import java.util.*;

class customer {
    private String name;
    private boolean member;
    private String membertype;

    public customer() {
        this.member = false;
    }

    public customer(String name, boolean member, String membertype) {
        this.name = name;
        this.member = member;
        this.membertype = membertype;
    }

    public String getName() {
        return name;
    }

    public boolean ismember() {
        return member;
    }

    public String getmembertype() {
        return membertype;
    }

    public void setmembertype(String membertype) {
        this.membertype = membertype;
    }

    @Override
    public String toString() {
        return "Customer name =" + name + ", member = " + member + ", membertype = " + membertype + "";
    }

}

class discountrate {
    private static double servicediscountpremium = 0.2;
    private static double servicediscountgold = 0.15;
    private static double servicediscountsilver = 0.1;
    private static double productdiscountpremium = 0.1;
    private static double productdiscountgold = 0.1;
    private static double productdiscountsilver = 0.1;

    public static double getservicediscountrate(String type) {
        switch (type) {
            case "premium":
                return servicediscountpremium;
            case "gold":
                return servicediscountgold;
            case "silver":
                return servicediscountsilver;
            default:
                throw new IllegalArgumentException("Wrong service type specified");
        }
    }

    public static double getproductdiscountrate(String type) {
        switch (type) {
            case "premium":
                return productdiscountpremium;
            case "gold":
                return productdiscountgold;
            case "silver":
                return productdiscountsilver;
            default:
                throw new IllegalArgumentException("Wrong service type specified");
        }
    }

}

class visit {
    private customer name;
    private Date date;
    private double serviceexpense;
    private double productexpense;

    public visit(customer name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getcoustomername() {
        return name.getName();
    }

    public double getserviceexpenses() {
        return serviceexpense;
    }

    public void setserviceexpenses(double serviceexpense) {
        this.serviceexpense = this.serviceexpense + serviceexpense;
    }

    public double getproductexpense() {
        return productexpense;
    }

    public void setproductexpense(double productexpense) {
        this.productexpense = this.productexpense + productexpense;
    }

    public double gettotalexpense() {
        return (serviceexpense - (serviceexpense * discountrate.getservicediscountrate(name.getmembertype()))) +
                (productexpense - (productexpense * discountrate.getproductdiscountrate(name.getmembertype())));
    }

    @Override
    public String toString() {
        return "Visit{ customer name = " + name.getName() + ", customer member = " + name.ismember()
                + ", customer member type =" + name.getmembertype() + ",date = " + date + ", service expense = "
                + serviceexpense + ", product expense = " + productexpense + "}";

    }
}

public class testdiscountsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();
        boolean member1 = sc.nextBoolean();
        sc.nextLine();
        String membertype1 = sc.nextLine();

        String name2 = sc.nextLine();
        boolean member2 = sc.nextBoolean();
        sc.nextLine();
        String membertype2 = sc.nextLine();

        double serviceexpense1 = sc.nextDouble();
        double productexpense1 = sc.nextDouble();

        double productexpense2 = sc.nextDouble();

        customer c1 = new customer(name1, member1, membertype1);
        customer c2 = new customer(name2, member2, membertype2);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        visit v1 = new visit(c1, new Date());
        System.out.println(v1.toString());
        v1.setproductexpense(productexpense1);
        v1.setproductexpense(productexpense2);
        v1.setserviceexpenses(serviceexpense1);

        System.out.println(v1.toString());
        System.out.println("Total expense mase by: " + v1.getcoustomername() + "=" + v1.gettotalexpense() + "");
        sc.close();
    }
}