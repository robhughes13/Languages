//Rob Hughes
//Tartaro 122
//Keeping track of water intake in a day
 
import java.util.Scanner;

 class WaterBank {
  int dailyGoal;
  int waterIntake;
  Scanner scan;
  WaterBank() {
    this.waterIntake=0;
    this.dailyGoal=0;
    this.scan= new Scanner(System.in);
  }
  void newDay() { //restarts the day and prompts user
    System.out.println("In ounces, what do you want your daily water intake to be?");
    this.dailyGoal= scan.nextInt();
    this.waterIntake=0;
    System.out.println("Your new daily water goal is "+ this.dailyGoal + " ounces.");
  }
  
  void recordWater() { //records amount of water
    System.out.println("How much water have you had in ounces?");
    this.waterIntake= this.waterIntake+ scan.nextInt();
    this.reportRemaining();
  }
  
  void reportRemaining() { //reports amount of water remaining to drink that day
    int totalCups= (this.dailyGoal-this.waterIntake)/8; //divides ounces to get cups
    int totalOunces= (this.dailyGoal-this.waterIntake)% 8; //finds the remainder of above, giving the ounces 
    System.out.println("You have " + totalCups + " cups and " + totalOunces+ " ounces remaining to drink today.");
  }
  public static void main(String[]args){
    WaterBank wb= new WaterBank();
    wb.newDay();
  }
                                    
 }   
  