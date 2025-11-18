

    class CardStrategy {
        +pay(amount: double) double
    }

    class YapeStrategy {
        +pay(amount: double) double
    }

    class CashStrategy {
        +pay(amount: double) double
    }

    PaymentStrategy <|.. CardStrategy
    PaymentStrategy <|.. YapeStrategy
    PaymentStrategy <|.. CashStrategy

    class Payment {
        -amount: double
        -strategy: PaymentStrategy
        +process() void
    }

    class Observer {
        <<interface>>
        +update(payment: Payment) void
    }

    class PaymentProcessor {
        -observers: List~Observer~
        -strategy: PaymentStrategy
        +addObserver(obs: Observer) void
        +removeObserver(obs: Observer) void
        +notifyObservers(payment: Payment) void
        +setStrategy(s: PaymentStrategy) void
        +processPayment(amount: double) Payment
    }

    PaymentProcessor --> PaymentStrategy
    PaymentProcessor o-- Observer
    Payment --> PaymentStrategy
