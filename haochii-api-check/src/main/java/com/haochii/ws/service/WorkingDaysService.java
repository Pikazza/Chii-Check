package com.haochii.ws.service;

import com.haochii.ws.model.Items;
import com.haochii.ws.model.WorkingDays;
import com.haochii.ws.model.WorkingDaysUpdtd;

public interface WorkingDaysService {

    WorkingDays updateWorkingDays(WorkingDaysUpdtd item);

    WorkingDays addWorkingDays(WorkingDays item);
    
}
