package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoManager {
    public Video addvideo(Video video);
    public Video updatevideo(Video video);
    public Video getVideoById (Integer id);
    public List<Video> getAllVideo();
    public Boolean DeleteVideoById (Integer id);
    public Boolean DeleteVideo (Video video);
    public Page<Video> searchVideo(String keyword, int page, int taille);
    public List<Video> getByKeyword(String keyword);


}
