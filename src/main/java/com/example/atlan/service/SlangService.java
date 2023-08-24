package com.example.atlan.service;

import com.example.atlan.entity.Slang;
import com.example.atlan.repository.SlangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlangService {

    @Autowired
    private SlangRepository slangRepository;

    public List<String> getSlangsByCity(Long cityId) {

        List<String> slangtext = null;
        List<Slang> list=slangRepository.findByCityCityId(cityId);

        for(int i=0;i<list.size();i++)
        {
            Slang se=list.get(i);
            slangtext.add(se.getSlangText());
        }

      return slangtext;
    }
}
