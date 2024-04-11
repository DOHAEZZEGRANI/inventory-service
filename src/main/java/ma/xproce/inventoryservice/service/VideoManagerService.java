package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoManagerService implements VideoManager{
    @Autowired
    private VideoRepository videoRepository;
    @Override
    public List<Video> getAllVideo() {
       try {
           return videoRepository.findAll();
       }catch (Exception e){
           System.out.println(e.getMessage());
           return null;
       }
    }

    @Override
    public Video addvideo(Video video) {
        try {
            return videoRepository.save(video);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean DeleteVideo(Video video) {
        try {
             videoRepository.delete(video);
             return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean DeleteVideoById(Integer id) {
        try {
            videoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Video getVideoById(Integer id) {
        try {
            return videoRepository.findById(id).get();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Video updatevideo(Video video) {
        try {
            return videoRepository.save(video);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Page<Video> searchVideo(String keyword, int page, int taille) {
        return videoRepository.findByDescriptionContains(keyword, (Pageable) PageRequest.of(page, taille));
    }

    @Override
    public List<Video> getByKeyword(String keyword) {
        return null;
    }
}
