package com.pay.paycommunal.service.impl;

import com.pay.paycommunal.entities.Pattern;

import java.util.List;

public interface PatternServiceInterface {
    List<Pattern> getAllPatterns();

    void saveOrUpdatePattern(Pattern pattern);

    Pattern getPattern(long id);

    void deletePattern(long id);

    List<Pattern> getAddressForPattern(Long address);

    List<Pattern> getNameForPattern(String name);
}
