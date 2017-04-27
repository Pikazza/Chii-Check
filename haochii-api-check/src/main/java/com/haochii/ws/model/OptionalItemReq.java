package com.haochii.ws.model;

import org.bson.types.ObjectId;

public class OptionalItemReq {
    
    private String itemId = null;
    private String optionalItemId = null;
    private String optionName= null;
    private String optionPrice= null;
    private String optionOfferPrice= null;
    private String optionStatus= null;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getOptionalItemId() {
        return optionalItemId;
    }
    public void setOptionalItemId(String optionalItemId) {
        this.optionalItemId = optionalItemId;
    }
    public String getOptionName() {
        return optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    public String getOptionPrice() {
        return optionPrice;
    }
    public void setOptionPrice(String optionPrice) {
        this.optionPrice = optionPrice;
    }
    public String getOptionOfferPrice() {
        return optionOfferPrice;
    }
    public void setOptionOfferPrice(String optionOfferPrice) {
        this.optionOfferPrice = optionOfferPrice;
    }
    public String getOptionStatus() {
        return optionStatus;
    }
    public void setOptionStatus(String optionStatus) {
        this.optionStatus = optionStatus;
    }
    
}
