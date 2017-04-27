package com.haochii.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haochii.ws.model.Day;
import com.haochii.ws.model.OptionalItems;
import com.haochii.ws.model.WorkingDays;
import com.haochii.ws.model.WorkingDaysUpdtd;
import com.haochii.ws.repository.WorkingDaysRepository;
import com.haochii.ws.service.WorkingDaysService;

@Service
public class WorkingDaysServiceImpl implements WorkingDaysService{

    
    private final WorkingDaysRepository workingDaysRepository;
    
    @Autowired
    public WorkingDaysServiceImpl(WorkingDaysRepository workingDaysRepository){
        this.workingDaysRepository = workingDaysRepository;
    }
    
    
    @Override
    public WorkingDays updateWorkingDays(WorkingDaysUpdtd item) {
        WorkingDays workingDb = workingDaysRepository.findOne(item.getDaysId());
        List<Day> tobeAdded = new ArrayList<Day>();
        List<Day> reqDays = item.getListOfDays();
        for (Day subday : reqDays) {
            // OptionalItems tempsubItem  = 
            workingDb.getListOfDays().stream().filter(daytemp -> daytemp.equals(subday))
                 .forEach((daytemp) -> {
                     System.out.println("the loop in side stream is "+daytemp.toString());
                     daytemp.setHours(subday.getHours());
                 });
             boolean ee=  workingDb.getListOfDays().stream().anyMatch(daytemp ->(daytemp.equals(subday)));
              System.out.println("the value of boolean is "+ee);
              if(!ee){
              System.out.println("the ##### before "+subday.toString());
              Day ss =new Day(subday.getDay(),subday.getHours());
              tobeAdded.add(ss);
              System.out.println("the ##### in side stream is "+subday.toString());
              }
     }

       workingDb.getListOfDays().addAll(tobeAdded);
       
       Day dayMax = reqDays.stream().max((d1,d2) -> Integer.compare(Integer.valueOf( d1.getHours()),Integer.valueOf(d2.getHours())) ).get();
       Day dayMin = reqDays.stream().min((d1,d2) -> Integer.compare(Integer.valueOf( d1.getHours()),Integer.valueOf(d2.getHours())) ).get();
       workingDb.setMaxavg(dayMax.getHours());
       workingDb.setMaxTotalPerWeek(String.valueOf(Integer.valueOf(dayMax.getHours()) * 7));
       workingDb.setMinAvg(dayMin.getHours());
       workingDb.setMinTotalPerWeek(String.valueOf(Integer.valueOf(dayMin.getHours()) * 7));
        WorkingDays workingRes = workingDaysRepository.save(workingDb);
       return  workingRes;
    }


    @Override
    public WorkingDays addWorkingDays(WorkingDays item) {
         WorkingDays workingRes = workingDaysRepository.save(item);
        return workingRes;
    }
    
    
    
}
