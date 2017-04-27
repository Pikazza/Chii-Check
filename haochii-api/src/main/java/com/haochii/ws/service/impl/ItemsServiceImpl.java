package com.haochii.ws.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.ValidationUtils;

import com.haochii.ws.model.Items;
import com.haochii.ws.model.OptionalItemReq;
import com.haochii.ws.model.OptionalItemReqUpdtd;
import com.haochii.ws.model.OptionalItems;
import com.haochii.ws.repository.ItemsRepository;
import com.haochii.ws.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
    
    
    private final ItemsRepository itemsRepository;
    
    public ItemsServiceImpl(ItemsRepository itemsRepository) {
       this.itemsRepository=itemsRepository;
    }
    @Override
    public Items addItem(Items item) {
        // TODO Auto-generated method stub
        System.out.println("items "+item.getCategory());
        Items itemRes=itemsRepository.save(item);
        return itemRes;
    }
    @Override
    public Items updatePartItem(OptionalItemReq item) {
        Items itemDb = itemsRepository.findOne(item.getItemId());
        String WW=item.getOptionalItemId();
       if(!StringUtils.isEmpty(WW)){
        OptionalItems tempsubItem = itemDb.getOptionalItems().stream().filter(item2 -> item2.getOptionalItemId().equals(WW))
            .reduce((a, b) -> {
                throw new IllegalStateException("Multiple elements: " + a + ", " + b);
            })
            .get();
        tempsubItem.setOptionName(item.getOptionName());
        tempsubItem.setOptionOfferPrice(item.getOptionOfferPrice());
        tempsubItem.setOptionStatus(item.getOptionStatus());
        tempsubItem.setOptionPrice(item.getOptionPrice());
        System.out.println("the current type is "+ tempsubItem.toString());
        }
       else{
           OptionalItems oi= new OptionalItems(item.getOptionName(), item.getOptionPrice(), item.getOptionOfferPrice(),item.getOptionStatus());
          List<OptionalItems> sublist = itemDb.getOptionalItems();
          sublist.add(oi);
       }
        Items itemRes=itemsRepository.save(itemDb);
        return itemRes;
    }
    @Override
    public Items addPartItem(OptionalItemReq item) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Items deletePartItem(OptionalItemReq item) {
        Items itemDb = itemsRepository.findOne(item.getItemId());
        String WW=item.getOptionalItemId();
        OptionalItems tempsubItem = itemDb.getOptionalItems().stream().filter(item2 -> item2.getOptionalItemId().equals(WW))
            .reduce((a, b) -> {
                throw new IllegalStateException("Multiple elements: " + a + ", " + b);
            })
            .get();
        itemDb.getOptionalItems().remove(tempsubItem);
        System.out.println("the current type is "+ tempsubItem.toString());
        Items itemRes=itemsRepository.save(itemDb);
        return itemRes;
    }
    @Override
    public Items updateWithoutIdSubItem(OptionalItemReqUpdtd item) {
        Items itemDb = itemsRepository.findOne(item.getItemId());
        List<OptionalItems> reqSubItemList = item.getOptionalItems();
        List<OptionalItems> tobeAdded = new ArrayList<OptionalItems>();
        for (OptionalItems optionalItems : reqSubItemList) {
           // OptionalItems tempsubItem  = 
          itemDb.getOptionalItems().stream().filter(itemtemp -> itemtemp.equals(optionalItems))
                .forEach((itemtemp) -> {
                    System.out.println("the loop in side stream is "+itemtemp.toString());
                    itemtemp.setOptionName(optionalItems.getOptionName());
                    itemtemp.setOptionOfferPrice(optionalItems.getOptionOfferPrice());
                    itemtemp.setOptionPrice(optionalItems.getOptionPrice());
                    itemtemp.setOptionStatus(optionalItems.getOptionStatus());
                    System.out.println("the loop in side stream is After "+itemtemp.toString());
                });
            boolean ee=  itemDb.getOptionalItems().stream().anyMatch(itemtemp ->(itemtemp.equals(optionalItems)));
             System.out.println("the value of boolean is "+ee);
             if(!ee){
             System.out.println("the ##### before "+optionalItems.toString());
             OptionalItems ss =new OptionalItems(optionalItems.getOptionName(), optionalItems.getOptionPrice(), optionalItems.getOptionOfferPrice(), optionalItems.getOptionStatus());
             tobeAdded.add(ss);
             System.out.println("the ##### in side stream is "+optionalItems.toString());
             }
    }
        itemDb.getOptionalItems().addAll(tobeAdded);
        Items itemRes=itemsRepository.save(itemDb);
        return itemRes;
    }
    @Override
    public Items deleteWithoutIdSubItem(OptionalItemReqUpdtd item) {
        Items itemDb = itemsRepository.findOne(item.getItemId());
        List<OptionalItems> reqSubItemList = item.getOptionalItems();
        for (OptionalItems optionalItems : reqSubItemList) {
           // OptionalItems tempsubItem  = 
          List<com.haochii.ws.model.OptionalItems> toBeDeletedist = itemDb.getOptionalItems().stream().filter(itemtemp -> itemtemp.equals(optionalItems))
                .collect(Collectors.toList());
          itemDb.getOptionalItems().removeAll(toBeDeletedist);
    }
        Items itemRes=itemsRepository.save(itemDb);
        return itemRes;
    }
    
}
