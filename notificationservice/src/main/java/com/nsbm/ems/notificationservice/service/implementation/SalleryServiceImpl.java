package com.nsbm.ems.notificationservice.service.implementation;

import com.nsbm.ems.notificationservice.model.Sallery;
import com.nsbm.ems.notificationservice.repository.SalleryRepository;
import com.nsbm.ems.notificationservice.service.SalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleryServiceImpl implements SalleryService {

    @Autowired
    private SalleryRepository salleryRepository;

    @Override
    public String saveSalNotification(Sallery sallery) {
        try {
            salleryRepository.save(sallery);
            return "Sallery saved Successfully";
        } catch (Exception e) {
            return "Something went wrong";
        }
    }

    @Override
    public String deleteSalNotification(Long sId) {
        try {
            if(salleryRepository.findById(sId).isPresent())
            {
                salleryRepository.deleteById(sId);
                return "Sallery deleted Successfully";
            }
            else
            {
                return "Record doesn't exist for this ID";
            }
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateSalNotification(Long sId, Sallery sallery) {

       try {
            Optional<Sallery> credentialOptional = salleryRepository.findById(sId);
            Sallery sallery1 = credentialOptional.get();
            sallery1.setMsg(sallery.getMsg());
            sallery1.setEmpNic(sallery.getEmpNic());
            sallery1.setTimeStamp(sallery.getTimeStamp());
            sallery1.setVal(sallery.getVal());

            return salleryRepository.save(sallery1).getMsg();
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public ResponseEntity<?> getAllSalNotifications() {

        try {
            return ResponseEntity.ok(salleryRepository.findAll());
        }catch (Exception e) {

            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @Override
    public ResponseEntity<?> getSalNotificationById(Long sId) {
        try {
            return ResponseEntity.ok(salleryRepository.findById(sId).get());
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}


