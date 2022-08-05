package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.Pattern;
import com.pay.paycommunal.service.impl.PatternServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pat")
public class PatternController {
    PatternServiceInterface patternServiceInterface;

    @Autowired
    public PatternController(PatternServiceInterface patternServiceInterface) {
        this.patternServiceInterface = patternServiceInterface;
    }

    @GetMapping("/patterns")
    public List<Pattern> getAllPatterns() {
        return patternServiceInterface.getAllPatterns();
    }

    @PostMapping("/pattern")
    public Pattern saveOrUpdatePattern(@RequestBody Pattern pattern) {
        patternServiceInterface.saveOrUpdatePattern(pattern);
        return pattern;
    }

    @GetMapping("/pattern/{id}")
    public Pattern getPattern(@PathVariable long id) {
        return patternServiceInterface.getPattern(id);
    }

    @DeleteMapping("/pattern/{id}")
    public void deletePattern(@PathVariable long id) {
        patternServiceInterface.deletePattern(id);
    }

    @GetMapping("/patternAddress/{address}")
    public List<Pattern> getAddressForPattern(@PathVariable Long address) {
        return patternServiceInterface.getAddressForPattern(address);
    }

    @GetMapping("/patternName/{name}")
    public List<Pattern> getNameForPattern(@PathVariable String name) {
        return patternServiceInterface.getNameForPattern(name);
    }
}
