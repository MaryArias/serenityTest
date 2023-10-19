package models;

import models.IRequest;

public class CardPaymentRequest implements IRequest {
    private String hierLabelIdReference;
    private String orderId;
    private String refTransactionId;

    public CardPaymentRequest() {
        this.hierLabelIdReference = "";
        this.orderId = "";
        this.refTransactionId = "";
    }

    public String getHierLabelIdReference() {
        return hierLabelIdReference;
    }

    public void setHierLabelIdReference(String hierLabelIdReference) {
        this.hierLabelIdReference = hierLabelIdReference;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefTransactionId() {
        return refTransactionId;
    }

    public void setRefTransactionId(String refTransactionId) {
        this.refTransactionId = refTransactionId;
    }
}