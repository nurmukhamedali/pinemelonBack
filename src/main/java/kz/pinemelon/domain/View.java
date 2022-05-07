package kz.pinemelon.domain;

public class View {
    public interface ComponentView {
        interface Public {}
        interface Internal extends Public {}
    }
    public interface CartView {
        interface Public {}
        interface Internal extends Public {}
    }
    public interface CartItemView {
        interface Public {}
        interface Internal extends Public {}
    }
    public interface CustomerView {
        interface Public {}
        interface Internal extends Public {}
    }
}

