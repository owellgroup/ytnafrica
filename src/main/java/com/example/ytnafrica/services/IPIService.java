package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Gender;
import com.example.ytnafrica.models.IPI;
import com.example.ytnafrica.repositories.IPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPIService {
    @Autowired
    private IPIRepository ipiRepository;

    //posting
    public IPI saveIPI(IPI ipi) {
        return ipiRepository.save(ipi);
    }
    //get all
    public List<IPI> getIPI() {
        return ipiRepository.findAll();
    }

    //get by Id
    public Optional<IPI> getIPI(long id) {
        return ipiRepository.findById(id);
    }
    //updating
    public IPI updateIPI(IPI ipip) {
        IPI ip = ipiRepository.findById(ipip.getId()).orElse(null);
        ip.setIPI_ID(ipip.getIPI_ID());
        return ipiRepository.save(ipip);
    }

    //deleting
    public void deleteIPI(long id) {
        ipiRepository.deleteById(id);
    }

}
