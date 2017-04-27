package com.haochii.ws.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class OptionalItems {
    
    
    @Id
    private ObjectId optionalItemId = null;
    private String optionName= null;
    private String optionPrice= null;
    private String optionOfferPrice= null;
    private String optionStatus= null;
    
    
    public OptionalItems(String optionName, String optionPrice, String optionOfferPrice, String optionStatus) {
        super();
        this.optionalItemId= ObjectId.get();
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.optionOfferPrice = optionOfferPrice;
        this.optionStatus = optionStatus;
    }
    
    public OptionalItems() {
        this.optionalItemId=ObjectId.get();
    }
    
    public String getOptionalItemId() {
        return optionalItemId.toString();
    }
    public void setOptionalItemId(ObjectId optionalItemId) {
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
    @Override
    public String toString() {
        return "OptionalItems [optionalItemId=" + optionalItemId + ", optionName=" + optionName + ", optionPrice=" + optionPrice
                + ", optionOfferPrice=" + optionOfferPrice + ", optionStatus=" + optionStatus + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
        result = prime * result + ((optionPrice == null) ? 0 : optionPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OptionalItems other = (OptionalItems) obj;
        if (optionName == null) {
            if (other.optionName != null)
                return false;
        } else if (!optionName.equals(other.optionName))
            return false;
        if (optionPrice == null) {
            if (other.optionPrice != null)
                return false;
        } else if (!optionPrice.equals(other.optionPrice))
            return false;
        return true;
    }
    
    
}
