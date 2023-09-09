package cvetkov.homework.behavioral.chain2;

public class ApplicationInput extends ApplicationProcessor {

    @Override
    protected void processInternal(Application application) {
        application.addHistoryRecord("Заявление принято");
    }

    @Override
    public String getProcessorName() {
        return "Прием заявления";
    }
}
