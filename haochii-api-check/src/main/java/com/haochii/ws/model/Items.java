package com.haochii.ws.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Items {
    
    @Id
    private String itemId = null;
    private String itemName= null;
    private String itemDesc= null;
    private String price= null;
    private String offerPrice= null;
    private String status= null;
    private String category= null;
    private List<OptionalItems> optionalItems = new ArrayList<OptionalItems>();

    public List<OptionalItems> getOptionalItems() {
        return optionalItems;
    }
    public void setOptionalItems(List<OptionalItems> optionalItems) {
        this.optionalItems = optionalItems;
    }
    public String getItemId() {
        return itemId.toString();
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getOfferPrice() {
        return offerPrice;
    }
    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
        result = prime * result + ((offerPrice == null) ? 0 : offerPrice.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        Items other = (Items) obj;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (itemDesc == null) {
            if (other.itemDesc != null)
                return false;
        } else if (!itemDesc.equals(other.itemDesc))
            return false;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        if (offerPrice == null) {
            if (other.offerPrice != null)
                return false;
        } else if (!offerPrice.equals(other.offerPrice))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", price=" + price + ", offerPrice=" + offerPrice
                + ", status=" + status + ", category=" + category + ", optionalItems=" + optionalItems + "]";
    }
}
