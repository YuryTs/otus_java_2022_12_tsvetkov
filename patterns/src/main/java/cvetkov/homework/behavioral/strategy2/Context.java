package cvetkov.homework.behavioral.strategy2;

class Context {
    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void applyStrategy() {
        strategy.transportation();
    }
}
