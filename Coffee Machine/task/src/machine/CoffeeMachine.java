package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private CoffeeMachineState state;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            coffeeMachine.writeMessage();

            String value = scanner.next();

            if (value.equalsIgnoreCase("exit")) {
                break;
            }

            coffeeMachine.enter(value);
        }
    }

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public CoffeeMachineState getState() {
        return this.state;
    }

    public void writeMessage() {
        if (this.state == null) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            return;
        }
        switch (this.state) {
            case WAITING_COFFEE_TYPE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                break;
            case WAITING_ADD_WATER:
                System.out.print("Write how many ml of water do you want to add:");
                break;
            case WAITING_ADD_MILK:
                System.out.print("Write how many ml of milk do you want to add:");
                break;
            case WAITING_ADD_COFFEE_BEANS:
                System.out.print("Write how many grams of coffee beans do you want to add:");
                break;
            case WAITING_ADD_CUPS:
                System.out.print("Write how many disposable cups of coffee do you want to add:");
                break;
        }
    }

    public void enter(String value) {
        if (value.equalsIgnoreCase("back")) {
            this.state = null;
            return;
        }

        if (this.state == null) {
            this.execute(value);
        } else {
            this.enterValue(value);
            this.next();
        }
    }

    private void enterValue(String value) {
        switch (this.state) {
            case WAITING_COFFEE_TYPE:
                this.makeCoffeeWithType(value);
                break;
            case WAITING_ADD_WATER:
                this.addWater(Integer.parseInt(value));
                break;
            case WAITING_ADD_MILK:
                this.addMilk(Integer.parseInt(value));
                break;
            case WAITING_ADD_COFFEE_BEANS:
                this.addCoffeeBeans(Integer.parseInt(value));
                break;
            case WAITING_ADD_CUPS:
                this.addCups(Integer.parseInt(value));
                break;
        }
    }

    private void execute(String action) {
        switch (action) {
            case "buy":
                this.buy();
                break;

            case "fill":
                this.fill();
                break;

            case "take":
                this.take();
                break;

            case "remaining":
                this.remaining();
                break;
        }
    }

    private void next() {
        if (this.state == null) {
            return;
        }
        switch (this.state) {
            case WAITING_ADD_WATER:
                this.state = CoffeeMachineState.WAITING_ADD_MILK;
                break;
            case WAITING_ADD_MILK:
                this.state = CoffeeMachineState.WAITING_ADD_COFFEE_BEANS;
                break;
            case WAITING_ADD_COFFEE_BEANS:
                this.state = CoffeeMachineState.WAITING_ADD_CUPS;
                break;
            case WAITING_ADD_CUPS:
            case WAITING_COFFEE_TYPE:
                this.state = null;
                break;
        }
    }

    private void buy() {
        this.state = CoffeeMachineState.WAITING_COFFEE_TYPE;
    }

    private void fill() {
        this.state = CoffeeMachineState.WAITING_ADD_WATER;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    private void makeCoffeeWithType(String type) {
        switch (type) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
        }
    }

    private void makeEspresso() {
        boolean isDone = makeCoffee(250, 0, 16);

        if (isDone) {
            money += 4;
        }
    }

    private void makeLatte() {
        boolean isDone = makeCoffee(350, 75, 20);

        if (isDone) {
            money += 7;
        }
    }

    private void makeCappuccino() {
        boolean isDone = makeCoffee(200, 100, 12);

        if (isDone) {
            money += 6;
        }
    }

    private boolean makeCoffee(int waterRequired, int milkRequired, int coffeeBeansRequired) {
        if (water < waterRequired) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (milk < milkRequired) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (coffeeBeans < coffeeBeansRequired) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= waterRequired;
        milk -= milkRequired;
        coffeeBeans -= coffeeBeansRequired;
        cups--;

        return true;
    }

    private void addWater(int value) {
        water += value;
    }

    private void addMilk(int value) {
        milk += value;
    }

    private void addCoffeeBeans(int value) {
        coffeeBeans += value;
    }

    private void addCups(int value) {
        cups += value;
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

}

enum CoffeeMachineState {
    WAITING_ADD_WATER,
    WAITING_ADD_MILK,
    WAITING_ADD_COFFEE_BEANS,
    WAITING_ADD_CUPS,
    WAITING_COFFEE_TYPE;
}



