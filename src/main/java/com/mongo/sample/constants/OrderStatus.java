package com.mongo.sample.constants;

public enum OrderStatus {

    Browsing(false),
    Placing(false),
    PreConfirmed(false),
    Confirmed(true),
    Refunding(true),
    Fulfilling(true), // deprecated
    Complete(true), // deprecated
    Deleted(false),
    PendingFraudCheck(false),
    Fraud(false);

    private final boolean isRefundable;

    private OrderStatus(boolean isRefundable) {
        this.isRefundable = isRefundable;

    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public static boolean isPlaced(OrderStatus state) {
        if (state == null) return false;
        switch (state) {
        case Confirmed:
        case Refunding:
        case Fulfilling: // deprecated
        case Complete: // deprecated
        case PendingFraudCheck:
        case Fraud:
            return true;
        default:
            return false;
        }
    }

    public static boolean isVoidable(OrderStatus state) {
        switch (state) {
        case Confirmed:
            return true;
        default:
            return false;
        }
    }

}
