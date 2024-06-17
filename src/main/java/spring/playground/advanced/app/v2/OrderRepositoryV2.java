package spring.playground.advanced.app.v2;

public class OrderRepositoryV2 {
    public void save(String itemId) { //저장 로직
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        System.out.println("OrderRepositoryV2 save");
        sleep(1000);
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
