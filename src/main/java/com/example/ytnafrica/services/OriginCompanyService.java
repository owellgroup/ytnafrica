package com.example.ytnafrica.services;

import com.example.ytnafrica.models.admin.OriginCompanyDetails;
import com.example.ytnafrica.repositories.OriginCompanyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OriginCompanyService {
    @Autowired
    private OriginCompanyDetailsRepository Orginal;

    //posting
    public OriginCompanyDetails createOrgin(OriginCompanyDetails originCompanyDetails){
        return Orginal.save(originCompanyDetails);
    }

    //get all
    public List<OriginCompanyDetails> findAll(){
        return Orginal.findAll();
    }

    //get by Id
    public Optional<OriginCompanyDetails> getById(Long id){
        return Orginal.findById(id);
    }

    //updating
    public OriginCompanyDetails update(OriginCompanyDetails originCompanyDetails){
        OriginCompanyDetails  org = Orginal.findById(originCompanyDetails.getId()).orElse(null);
        org.setCompanyAddress(originCompanyDetails.getCompanyAddress());
        org.setCompanyName(originCompanyDetails.getCompanyName());
        org.setCompanyPhone(originCompanyDetails.getCompanyPhone());
        org.setCompanyEmail(originCompanyDetails.getCompanyEmail());
        org.setCompanyWebsite(originCompanyDetails.getCompanyWebsite());
        return Orginal.save(org);
    }

    //deleting
    public void deleteById(Long id){
        Orginal.deleteById(id);
    }

}
