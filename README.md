# Chain of Responsibility

The Chain of Responsibility (COR) design pattern is used when more than one object handles a request and performs their corresponding responsibilities to complete the whole task.

The pattern can be used to achieve loose coupling in software design where the request can be passed through a chain of objects or request handler for processing. Based on some criteria in each handler object, it will handle the request or pass it to the next handler. 

![Chain of Responsibility](https://sourcemaking.com/files/sm/images/patterns/Chain_of_responsibility_example.png)

One great example of Chain of Responsibility pattern is an ATM machine (in German: Geldautomat). The user enters the amount to be dispensed and the machine dispenses the amount in terms of defined currency bills such as 50€, 20€, 10€ etc. If the user enters an amount that is not dispensible, the ATM machine throws an error. 

We will use the Chain of Responsibility pattern to implement a € bill dispenser machine.

If we try to implement the ATM machine strictly following the Chain of Responsibility Design pattern, we could implement a solution as in this blog entry: [https://medium.com/@dholnessii/behavioral-patterns-chain-of-responsibility-6b7a025ad293](https://medium.com/@dholnessii/behavioral-patterns-chain-of-responsibility-6b7a025ad293)

![COR class diagramm](https://cdn-images-1.medium.com/max/800/1*SKxf_rYg6akD7rQylffe6A.gif)

The abstract `Handler` is implemented in this example as an interface `Dispenser` and each € bill is represented an an implementation of a Dispenser class (e.g. `TwentyDispenser`, `TenDispenser`, and so on). Each `Dispenser` implementation is very similar leading to duplicate code.

In this example you should consider using **Java8 Functional Interfaces**. For this we will need a slighly changed class diagram.

@startuml

skinparam linetype polyline
skinparam linetype ortho


class ATMMachine {
+ {static} main (args: String[]): void
}

class ATMDispenserChain{
+ Function<CurrencyAmount, CurrencyAmount> ATM
}

class CurrencyDispenser{
+ {static} Function<CurrencyAmount, CurrencyAmount> handle (handler: int)
}

class CurrencyAmount{
- amount: int
+ getAmount(): int
+ setAmount(amount: int)
}


ATMMachine -- ATMDispenserChain 
ATMDispenserChain --> "*" CurrencyDispenser :handler_<int>
CurrencyDispenser ..> CurrencyAmount

@enduml

**You have the following tasks:**

[task][Implement the class CurrencyAmount](testClass[CurrencyAmount])

[task][Implement the class CurrencyDispenser](testClass[CurrencyDispenser]): The class CurrencyDispenser has a

```
public static Function<CurrencyAmount, CurrencyAmount> handle(int handler){
    return (amount) -> {
            if (amount.getAmount() >= handler) {
                System.out.println("Dispensing €" + handler + " x " + ...);
                amount.setAmount(...);
            }
            return amount;
        };
}
```

The `handler` parameter represents a € bill. The handle method will e.g. dispense as many 50€ bills as suitable for a given € amount (i.e. `(int) amount/handler` € bills).

[task][Implement the class ATMDispenserChain](testClass[ATMDispenserChain]): This class has a handler Function interface for each € bill. The list of available € bills can be looked up at e.g. [https://en.wikipedia.org/wiki/Euro_banknotes](https://en.wikipedia.org/wiki/Euro_banknotes). E.g.:  

```
Function<CurrencyAmount, CurrencyAmount> handler_500 = CurrencyDispenser.handle(500);
```


The Chain of Responsibility is easily created by creating a Function interface that chains the handler Functions, e.g.:

```
public Function<CurrencyAmount, CurrencyAmount> ATM = handler_500
            .andThen(handler_200)
            .andThen....

```


[task][Uncomment the code in the class ATMMachine](testAmount4)

[task][Run the program and have fun.](testAmount1,testAmount2,testAmount3)
