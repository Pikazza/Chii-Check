package com.haochii.ws.apiendpoint;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.haochii.ws.filter.JWTSecured;
import com.haochii.ws.model.Items;
import com.haochii.ws.model.OptionalItemReq;
import com.haochii.ws.model.OptionalItemReqUpdtd;
import com.haochii.ws.model.OptionalItems;
import com.haochii.ws.service.ItemsService;

@Path("/")
public class ItemsController {
    
private final ItemsService itemsService;
    
    
    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
}
 
    @POST
    @Path("/addItem")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public Items additem(Items item){
        System.out.println("in controller "+item.toString());
   
   return itemsService.addItem(item);
    
}
    
    @POST
    @Path("/updatePartItem")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public Items updatePartItem(OptionalItemReq item){
        System.out.println("in controller "+item.toString());
    return itemsService.updatePartItem(item);
}
    
    @POST
    @Path("/deletePartItem")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public Items deletePartItem(OptionalItemReq item){
        System.out.println("in controller "+item.toString());
    return itemsService.deletePartItem(item);
    
}
    
    @POST
    @Path("/updateWithoutIdSubItem")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public Items addPartItem(OptionalItemReqUpdtd item){
        System.out.println("in controller "+item.toString());
    return itemsService.updateWithoutIdSubItem(item);
    
}
    
    @POST
    @Path("/deleteWithoutIdSubItem")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public Items deletePartItem(OptionalItemReqUpdtd item){
        System.out.println("in controller "+item.toString());
    return itemsService.deleteWithoutIdSubItem(item);
    
    
}
}
