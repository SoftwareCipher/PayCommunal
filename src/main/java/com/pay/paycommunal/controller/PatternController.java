package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.Pattern;
import com.pay.paycommunal.service.impl.PatternServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "PatternController", description = "PatternController | Rest questions")
@RequestMapping("/pat")
public class PatternController {
    PatternServiceInterface patternServiceInterface;

    @Autowired
    public PatternController(PatternServiceInterface patternServiceInterface) {
        this.patternServiceInterface = patternServiceInterface;
    }

    @GetMapping("/patterns")
    @ApiOperation("Get all patterns")
    public List<Pattern> getAllPatterns() {
        return patternServiceInterface.getAllPatterns();
    }

    @PostMapping("/pattern")
    @ApiOperation("Save pattern")
    public Pattern saveOrUpdatePattern(@RequestBody Pattern pattern) {
        patternServiceInterface.saveOrUpdatePattern(pattern);
        return pattern;
    }

    @GetMapping("/pattern/{id}")
    @ApiOperation("Get pattern")
    public Pattern getPattern(@PathVariable long id) {
        return patternServiceInterface.getPattern(id);
    }

    @DeleteMapping("/pattern/{id}")
    @ApiOperation("delete pattern")
    public void deletePattern(@PathVariable long id) {
        patternServiceInterface.deletePattern(id);
    }

    @GetMapping("/patternAddress/{address}")
    @ApiOperation("get address for pattern")
    public List<Pattern> getAddressForPattern(@PathVariable Long address) {
        return patternServiceInterface.getAddressForPattern(address);
    }

    @GetMapping("/patternName/{name}")
    @ApiOperation("get name for pattern")
    public List<Pattern> getNameForPattern(@PathVariable String name) {
        return patternServiceInterface.getNameForPattern(name);
    }
}
