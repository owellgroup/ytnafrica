package com.example.ytnafrica.services;

import com.example.ytnafrica.models.MemberCategory;
import com.example.ytnafrica.repositories.MemberCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersCateroryServices {
    @Autowired
    private MemberCategoryRepository memberrepo;


    //posting
    public MemberCategory saveMemberCategory(MemberCategory membercategory){
        return memberrepo.save(membercategory);
    }
    //get all
    public List<MemberCategory> allMembers(){
        return memberrepo.findAll();
    }
    //get by id
    public Optional<MemberCategory> findMemberCategoryById(long id){
        return memberrepo.findById(id);
    }
    //updating
    public MemberCategory updateMemberCategory(MemberCategory membercategory){
            MemberCategory updatedMemberCategory = memberrepo.findById(membercategory.getId()).orElse(null
            );
            updatedMemberCategory.setCategoryName(membercategory.getCategoryName());
            return memberrepo.save(updatedMemberCategory);

    }

    //delete
    public void deleteMemberCategory(long id){
        memberrepo.deleteById(id);
    }

}
