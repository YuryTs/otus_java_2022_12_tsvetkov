package cvetkov.homework.behavioral.chain2;

public class ApplicationReader extends ApplicationProcessor {

    @Override
    protected void processInternal(Application application) {
        application.addHistoryRecord("Заявление рассмотрено");
    }

    @Override
    public String getProcessorName() {
        return "Рассмотрение заявления";
    }
}
