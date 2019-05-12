
package Q3_lambdas;


public class Invoice {
    int PartNumber;
    String PartDescription;
    int Quantity;
    double Price;

    public Invoice(int PartNumber, String PartDescription, int Quantity, double Price) {
        this.PartNumber = PartNumber;
        this.PartDescription = PartDescription;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    
    public int getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(int PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getPartDescription() {
        return PartDescription;
    }

    public void setPartDescription(String PartDescription) {
        this.PartDescription = PartDescription;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    @Override
    public String toString(){
       return "Invoice { PartNumber "+this.PartNumber +" PartDescription :"+this.PartDescription+" Quantity : "+this.Quantity+" Price : "+this.Price+" }";
    }         
}
