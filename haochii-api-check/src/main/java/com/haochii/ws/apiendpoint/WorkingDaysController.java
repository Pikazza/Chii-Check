package com.haochii.ws.apiendpoint;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochii.ws.model.Items;
import com.haochii.ws.model.OptionalItemReqUpdtd;
import com.haochii.ws.model.WorkingDays;
import com.haochii.ws.model.WorkingDaysUpdtd;
import com.haochii.ws.service.ItemsService;
import com.haochii.ws.service.WorkingDaysService;

@Component
@Path("/")
public class WorkingDaysController {
   
    private final WorkingDaysService workingDaysService;
    
    @Autowired
    public WorkingDaysController(WorkingDaysService workingDaysService){
        this.workingDaysService=workingDaysService;
    }
    
    @POST
    @Path("/addWorkingDays")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public WorkingDays addPartItem(WorkingDays item){
        System.out.println("in controller "+item.toString());
    return workingDaysService.addWorkingDays(item);
    
}
    
    @POST
    @Path("/updateWorkingDays")
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTSecured
    //@RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
public WorkingDays updatePartItem(WorkingDaysUpdtd item){
        System.out.println("in controller "+item.toString());
    return workingDaysService.updateWorkingDays(item);
    
}
}
