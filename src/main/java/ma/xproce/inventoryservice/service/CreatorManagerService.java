package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreatorManagerService implements CreatorManager {
    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    public Boolean deleteCreator(Creator creator) {
       try {
           creatorRepository.delete(creator);
           return true;
       }catch (Exception exception){
           System.out.println(exception.getMessage());
           return false;
       }
    }

    @Override
    public Boolean deleteCreatorByid(Integer id) {
        try {
            creatorRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Creator addCreator(Creator creator) {
        try {
            return creatorRepository.save(creator);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Creator getCreatorByid(Integer id) {
        try {
            return creatorRepository.findById(id).get();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Creator UpdateCreator(Creator creator) {
        try {
            return creatorRepository.save(creator);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Creator> getAllCreators() {
        try {
            return creatorRepository.findAll();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
