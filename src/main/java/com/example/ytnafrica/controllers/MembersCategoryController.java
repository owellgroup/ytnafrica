package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.MemberCategory;
import com.example.ytnafrica.services.MembersCateroryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memberscategory")
public class MembersCategoryController {
    @Autowired
    private MembersCateroryServices membersServices;

    //posting
    @PostMapping("/post")
    public MemberCategory saveMem(@RequestBody MemberCategory membercategory){
        return membersServices.saveMemberCategory(membercategory);
    }
    //get methods
    @GetMapping("/all")
    public List<MemberCategory> getAllMemberCategory(){
        return membersServices.allMembers();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<MemberCategory> getMemberCategoryById(@PathVariable long id){
        return membersServices.findMemberCategoryById(id);
    }

    //update
    @PutMapping("/update/{id}")
    public MemberCategory updateMemberCategory(@RequestBody MemberCategory membercategory, @PathVariable long id){
        membercategory.setId(id);
        return membersServices.updateMemberCategory(membercategory);
    }

    //Deleting
    @DeleteMapping("/delete/{id}")
    public void deleteMemberCategory(@PathVariable long id){
        membersServices.deleteMemberCategory(id);
    }

}
