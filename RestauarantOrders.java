public class RestaurantOrders {

    public Queue headChef;
    public Queue sousChef;
    public Queue waitingList;

    public RestaurantOrders() {
      this.headChef= new Queue(3);
      this.sousChef= new Queue(3);
      this.waitingList= new Queue();;

    }
    
    public void assign(String[] orders) {
        for (String order : orders) {
            try {
              this.headChef.enqueue(order);
              System.out.println("Order for " + order + " taken by Head Chef.");

            } catch (Error e) {
              if(sousChef.hasSpace()) {
                System.out.println("Head chef is busy!");     
                this.sousChef.enqueue(order);
                System.out.println("Head Chef is busy! Assign " + order + " order to Sous Chef.");
              } else{
                this.waitingList.enqueue(order);
                System.out.println("Both chefs are busy! Add " + order + " order to the waiting list.");
              }
              
            }

        }
        System.out.println("-----------------");
        System.out.println("You've got only " + this.waitingList.size + " orders on the waiting list. Keep up the hard work chefs!");
    }
    public static void main(String[]args) {}
}