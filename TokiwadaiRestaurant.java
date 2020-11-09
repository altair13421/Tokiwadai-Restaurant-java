import java.util.Scanner;

interface ITokiwadaiRestaurant {

    String returnMenu();

    void takeOrder();

    String showBill();

} // ItokiwadaiRestaurant.interface.class.java (Or Whatever)

class TokiwadaiRestaurant implements ITokiwadaiRestaurant {

    private String[] foodsList, drinksList, inventory;
    private double[] foodsPrice;
    private double bill, drinksPrice;

    // Specialty is Something That is Used in Child Class, No Need To Declare That
    // Again //
    private String specialty;
    private double specialtyPrice;
    // These Two Fields Are Set Only in The Child Class.

    private Scanner input = new Scanner(System.in);

    TokiwadaiRestaurant() {
        String[] inventory = new String[3];
        this.setInventory(inventory);
        this.setBill(0.0);
    } // DefaultConstructor - The Things That Needed To BE Done

    /***********************
     * Setters And Getters *
     ***********************/

    ////// Specialty /////////
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    //////////// specialty Price /////////
    public double getSpecialtyPrice() {
        return specialtyPrice;
    }

    public void setSpecialtyPrice(double specialtyPrice) {
        this.specialtyPrice = specialtyPrice;
    }

    /////// drinksList ///////
    public String[] getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(String[] drinksList) {
        this.drinksList = drinksList;
    }

    //////// Inventory /////////
    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    //////// DrinksPrice ////////
    public double getDrinksPrice() {
        return drinksPrice;
    }

    public void setDrinksPrice(double drinksPrice) {
        this.drinksPrice = drinksPrice;
    }

    //////// FoodPrice ///////
    public double[] getFoodsPrice() {
        return foodsPrice;
    }

    public void setFoodsPrice(double[] foodsPrice) {
        this.foodsPrice = foodsPrice;
    }

    /////// Bill //////////
    public double getBill() {
        return this.bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    //////// foodsList ////////
    public String[] getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(String[] foodsList) {
        this.foodsList = foodsList;
    }

    /*************************************
     * Ruling the Main/Common Interfaces *
     *************************************/

    public String returnMenu() {
        String[] foodsList = { "0. Omolette and Bread\t(2pcs)\t(4.99)", "1. Chicken Soup\t(One Bowl)\t(3.99)",
                "2. Shwarma\t(Large)\t(5.99)" };
        String menu = "\nFoods\n";
        for (String food : foodsList) {
            menu += food + "\n";
        } // enhamced Food (Pun, "Ham", No?)
        this.setFoodsList(foodsList);
        menu += "\nDrinks: \n";
        double[] foodsPrice = { 4.99, 3.99, 5.99 };
        this.setFoodsPrice(foodsPrice);

        String[] drinksList = { "0. Dew", "1. Sprite", "2. Coke" };
        this.setDrinksList(drinksList);
        this.setDrinksPrice(0.99);
        for (String drink : drinksList) {
            menu += drink + "\t" + this.getDrinksPrice() + "\n";
        } // enhanced Drinks

        return menu;
    } // returnMenu()

    public void takeOrder() {
        String[] inventory = this.getInventory();
        double billing = 0;
        String[] foodsList = this.getFoodsList();
        double[] foodsPrice = this.getFoodsPrice();
        System.out.print("Which Food Would You Like? (Enter -1 for None)\n> ");
        int foodKey = input.nextInt();
        if (foodKey > -1 && foodKey <= foodsList.length) {
            inventory[0] = foodsList[foodKey];
            billing += foodsPrice[foodKey];
        } // if - FoodKey
	else {
		inventory[0] = "No Food Chosen";
	} // else

        String[] drinksList = this.getDrinksList();
        double drinksPrice = this.getDrinksPrice();
        System.out.print("Which Drink Would You Like? (Enter -1 For None)\n> ");
        int drinkKey = input.nextInt();
        if (drinkKey > -1 && drinkKey <= drinksList.length) {
            inventory[1] = drinksList[drinkKey];
            billing += drinksPrice;
        } // if - DrinkKey
	else {
		inventory[1] = "No Drink Chosen";
	} // else

        this.setBill(billing);
        this.setInventory(inventory);
    } // takeOrder()

    public String showBill() {
        return null;
    } // showBill()

} // TokiwadaiRestaurant.class

class SeasideBranch extends TokiwadaiRestaurant {

    private Scanner input = new Scanner(System.in);

    SeasideBranch() {
        super();
    } // SeasideBranch() - Default Constructor

    /**************************************
     * Ruling The SeasideBranch Interface *
     **************************************/

    public String returnMenu() {
        String menu = super.returnMenu();
        menu += "\nSpecialty of This Restaurant\n";
        super.setSpecialtyPrice(9.99);
        super.setSpecialty("Shrimp\t\t" + getSpecialtyPrice());
        menu += super.getSpecialty() + "\n";
        return menu;
    } // returnMenu()

    public void takeOrder() {
        super.takeOrder();
        String[] inventory = super.getInventory();
        double billing = super.getBill();

        System.out.println("Would You Like the Specialty of this Restaurant?");
        System.out.print("Press 0 for No, and 1 for Yes\n> ");
        int specKey = input.nextInt();
        if (specKey == 1) {
            inventory[2] = super.getSpecialty() + "\t\t" + super.getSpecialtyPrice();
            billing += super.getSpecialtyPrice();
        } // if SpecKey
	else {
		inventory[2] = "No Specialty Chosen";
	} // else

        super.setInventory(inventory);
        super.setBill(billing);
    } // takeOrder()

    public String showBill() {
        String showBill = "";
        for (String inventoryItems : super.getInventory()) {
            showBill += inventoryItems + "\n";
        } // Enhanced For Inventory

        showBill += "Total bill = " + super.getBill();
        return showBill;
    } // showBill

} // SeasideBranch.class

class HillsideBranch extends TokiwadaiRestaurant {

    private Scanner input = new Scanner(System.in);

    HillsideBranch() {
        super();
    } // HillsideBranch() - Default Constructor

    /***************************************
     * Ruling The HillSideBranch Interface *
     ***************************************/

    public String returnMenu() {
        String menu = super.returnMenu();
        menu += "\nSpecialty of This Restaurant\n";
        super.setSpecialtyPrice(9.99);
        super.setSpecialty("Mozzarella Stix\t\t" + getSpecialtyPrice());
        menu += super.getSpecialty() + "\n";
        return menu;
    } // returnMenu()

    public void takeOrder() {
        super.takeOrder();
        String[] inventory = super.getInventory();
        double billing = super.getBill();

        System.out.println("Would You Like the Specialty of this Restaurant?");
        System.out.print("Press 0 for No, and 1 for Yes\n> ");
        int specKey = input.nextInt();
        if (specKey == 1) {
            inventory[2] = super.getSpecialty() + "\t\t" + super.getSpecialtyPrice();
            billing += super.getSpecialtyPrice();
        } // if SpecKey
	else {
		inventory[2] = "No Specialty Chosen";
	} // else

        super.setInventory(inventory);
        super.setBill(billing);
    } // takeOrder()

    public String showBill() {
        String showBill = "";
        for (String inventoryItems : super.getInventory()) {
            showBill += inventoryItems + "\n";
        } // Enhanced For Inventory

        showBill += "Total bill = " + super.getBill();
        return showBill;
    } // showBill

} // HillsideBranch.class

class MetropolisSideBranch extends TokiwadaiRestaurant {

    private Scanner input = new Scanner(System.in);

    MetropolisSideBranch() {
        super();
    } // SeasideBranch() - Default Constructor

    /***************************************
     * Ruling The MetropolisSide Interface *
     ***************************************/

    public String returnMenu() {
        String menu = super.returnMenu();
        menu += "\nSpecialty of This Restaurant\n";
        super.setSpecialtyPrice(9.99);
        super.setSpecialty("Aandey ala Burger\t\t" + getSpecialtyPrice());
        ///// Seeing That it's Always The Most Busy, And I Couldn't Think Of Anything
        ///// Else
        menu += super.getSpecialty() + "\n";
        return menu;
    } // returnMenu()

    public void takeOrder() {
        super.takeOrder();
        String[] inventory = super.getInventory();
        double billing = super.getBill();

        System.out.println("Would You Like the Specialty of this Restaurant?");
        System.out.print("Press 0 for No, and 1 for Yes\n> ");
        int specKey = input.nextInt();
        if (specKey == 1) {
            inventory[2] = super.getSpecialty() + "\t\t" + super.getSpecialtyPrice();
            billing += super.getSpecialtyPrice();
        } // if SpecKey
		else {
			inventory[2] = "No Specialty Chosen";
		}

        super.setInventory(inventory);
        super.setBill(billing);
    } // takeOrder()

    public String showBill() {
        String showBill = "";
        for (String inventoryItems : super.getInventory()) {
            showBill += inventoryItems + "\n";
        } // Enhanced For Inventory

        showBill += "Total bill = " + super.getBill();
        return showBill;
    } // showBill

} // MetropolisSideBranch.class

class MainTesting {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        changeLocation();
    } // main()

    public static void prompt(TokiwadaiRestaurant twdr) {
        System.out.println();
        System.out.println("Options:\n1. Show Menu\n2. Take Order\n3. Show The Bill");
        System.out.print("4. Change Location\n5. Exit\n> ");
        // while (inKey > 0 && inKey <= 6) {
        int inKey = input.nextInt();
        if (inKey == 1) {
            System.out.println(twdr.returnMenu());
            prompt(twdr);
        } else if (inKey == 2) {
            twdr.takeOrder();
            prompt(twdr);
        } else if (inKey == 3) {
            System.out.println(twdr.showBill() + " Bucks");
            prompt(twdr);
        } else if (inKey == 4) {
            changeLocation();
            prompt(twdr);
        } else if (inKey == 5) {
            System.exit(0);
        } else {
            System.out.println("Not In the Options!");
            System.out.println("ReCheck The Options and Then Input");
            prompt(twdr);
        } // else-If
    } // prompt

    static void changeLocation() {
        System.out.println("Out of three Locations, That Are:");
        String tokiwadai = " of Tokiwadai Restaurant";
        // For Easy Use in System.out.println Streams
        System.out.println("1. The Seaside Branch" + tokiwadai);
        System.out.println("2. The Hillside Branch" + tokiwadai);
        System.out.println("3. The MetropolisSide Branch" + tokiwadai);
        System.out.println("Where Do You Want to Go? (Type 1, 2, or 3)");
        System.out.print("> ");
        int inKey = 1;
        while (inKey <= 3 && inKey > 0) {
            inKey = input.nextInt();
            if (inKey == 1) {
                TokiwadaiRestaurant twdr = new SeasideBranch();
                prompt(twdr);
            } else if (inKey == 2) {
                TokiwadaiRestaurant twdr = new HillsideBranch();
                prompt(twdr);
            } else if (inKey == 3) {
                TokiwadaiRestaurant twdr = new MetropolisSideBranch();
                prompt(twdr);
            } else {
                System.out.println("Not In Options, Resetting Value Back To 1");
                inKey = 1;
            } // else - if
        } // while - inKey
    } // changeLocation

} // MainTesting.class