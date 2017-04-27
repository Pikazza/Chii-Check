package com.haochii.ws.service;

import com.haochii.ws.model.Items;
import com.haochii.ws.model.OptionalItemReq;
import com.haochii.ws.model.OptionalItemReqUpdtd;
import com.haochii.ws.model.OptionalItems;

public interface ItemsService {

    public Items addItem(Items item);

    public Items updatePartItem(OptionalItemReq item);

    public Items addPartItem(OptionalItemReq item);

    public Items deletePartItem(OptionalItemReq item);

    public Items updateWithoutIdSubItem(OptionalItemReqUpdtd item);

    public Items deleteWithoutIdSubItem(OptionalItemReqUpdtd item);
}
