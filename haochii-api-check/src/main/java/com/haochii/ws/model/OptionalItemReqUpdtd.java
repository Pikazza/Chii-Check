package com.haochii.ws.model;

import java.util.ArrayList;
import java.util.List;

public class OptionalItemReqUpdtd {
    
    
    private String itemId = null;
    private List<OptionalItems> optionalItems = new ArrayList<OptionalItems>();
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public List<OptionalItems> getOptionalItems() {
        return optionalItems;
    }
    public void setOptionalItems(List<OptionalItems> optionalItems) {
        this.optionalItems = optionalItems;
    }
    @Override
    public String toString() {
        return "OptionalItemReqUpdtd [itemId=" + itemId + ", optionalItems=" + optionalItems + "]";
    }
    
}
