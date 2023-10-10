package com.WEB2.backend.Service;

import com.WEB2.backend.Model.Usertable;
import com.WEB2.backend.Repository.UsertableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsertableService {

    @Autowired
    private UsertableRepository usertableRepository;

    public Iterable<Usertable> listAll(){
        return usertableRepository.findAll();
    }
}
