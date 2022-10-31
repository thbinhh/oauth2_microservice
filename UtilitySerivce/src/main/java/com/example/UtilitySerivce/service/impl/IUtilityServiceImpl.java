package com.example.UtilitySerivce.service.impl;

import com.example.UtilitySerivce.entites.Utility;
import com.example.UtilitySerivce.repository.UtilityRepository;
import com.example.UtilitySerivce.service.IUtilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IUtilityServiceImpl implements IUtilityService {
    @Autowired
    UtilityRepository utilityRepository;

    Logger log = LoggerFactory.getLogger(UtilityRepository.class);

    @Override
    public void save(Utility utility) {
        log.info("saving utility");
        utilityRepository.save(utility);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
    public Optional<Utility> update(int utilityId, Utility utility) {
        return utilityRepository.findById(utilityId);
    }

    @Override
    public void delete(int utilityId) {
        utilityRepository.deleteById(utilityId);
    }

    @Override
    public Optional<Utility> getUtilityById(int utilityId) {
        return utilityRepository.findById(utilityId);
    }

    @Override
    public Utility getUtilityByUtilityName(String utilityName) {
        return utilityRepository.findByUtilityName(utilityName);
    }

    @Override
    public List<Utility> getUtilities() {
        List<Utility> utilities = utilityRepository.findAll();
        return utilities;
    }
}
