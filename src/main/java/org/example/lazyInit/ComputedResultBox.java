package org.example.lazyInit;

public class ComputedResultBox {

    private Integer result = null;
    private final Integer param;

    public ComputedResultBox(Integer param) {
        this.param = param;
    }

    public Integer getResult() {
        if (result == null) {
            result = calculateNumber(param);
        }
        return result;
    }

    private Integer calculateNumber(Integer param) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return param * 100;
    }
}
