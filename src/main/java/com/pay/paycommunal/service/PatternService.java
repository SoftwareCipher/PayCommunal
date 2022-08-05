package com.pay.paycommunal.service;

import com.pay.paycommunal.entities.Pattern;
import com.pay.paycommunal.repository.PatternRepository;
import com.pay.paycommunal.service.impl.PatternServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatternService implements PatternServiceInterface {
    PatternRepository patternRepository;

    @Autowired
    public PatternService(PatternRepository patternRepository) {
        this.patternRepository = patternRepository;
    }

    @Override
    public List<Pattern> getAllPatterns() {
        return patternRepository.findAll();
    }

    @Override
    public void saveOrUpdatePattern(Pattern pattern) {
        patternRepository.saveAndFlush(pattern);
    }

    @Override
    public Pattern getPattern(long id) {
        Pattern pattern = null;
        Optional<Pattern> optional = patternRepository.findById(id);
        if(optional.isPresent()){
            pattern = optional.get();
        }else{
            System.out.println("Error! Pattern " + id + " not found!");
        }
        return pattern;
    }

    @Override
    public void deletePattern(long id) {
        patternRepository.deleteById(id);
    }

    @Override
    public List<Pattern> getAddressForPattern(Long address) {
        return patternRepository.getAddressForPattern(address);
    }

    @Override
    public List<Pattern> getNameForPattern(String name) {
        return patternRepository.getNameForPattern(name);
    }
}
