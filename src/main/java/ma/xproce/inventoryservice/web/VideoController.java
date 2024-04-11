package ma.xproce.inventoryservice.web;

import jakarta.validation.Valid;
import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;

@Controller

public class VideoController {
    @Autowired
     VideoManager videoManager;
    @PostMapping("/savevideo")
    public String ajoutervid(Model model,
                                 @Valid Video video,
                                 BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "ajoutervideo" ;
        }
        videoManager.addvideo(video);
        return "redirect:indexlayout"
                ;

    }
    @GetMapping("")
    public String start() {
        return "redirect:indexpage";
    }



        @GetMapping("/index")
         public String accueil (Model model){
        List<Video> videos=videoManager.getAllVideo();
        model.addAttribute("listvideo",videos);
        return "/indexlayout";
         }
    @GetMapping("detailsvideo")
    public String detailvideo(Model model,
                                @RequestParam(name = "id") Integer id) {

        Video video = videoManager.getVideoById(id);
        model.addAttribute("videoWithDetails", video);
        return "/detailvideo" ;

    }
    @GetMapping("/deletevideo")
    public String deletevideoAction(@RequestParam(name = "id") Integer id) {
        if (videoManager.DeleteVideoById(id)) {
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }
    @PostMapping("/ajouter")
    public String modifierVideoAction(Model model,
                                      @RequestParam(name = "id") Integer id,
                                      @RequestParam(name = "name") String name,
                                      @RequestParam(name = "url") String url,
                                      @RequestParam(name = "designation") String designation) {
        Video video = videoManager.getVideoById(id);
        if (video != null) {
            video.setName(name);
            video.setUrl(url);
            video.setDescription(designation);
            videoManager.updatevideo(video);
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }

    @GetMapping("/ajoutervideo")
    public String ajoutervideo(Model model) {
        model.addAttribute("video", new Video());
        return "ajoutervideo";
    }

    @PostMapping("/ajouterOnce")
    public String ajoutervideo(Model model,
                                 @Valid Video video,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "ajoutervideo" ;
        }
        videoManager.addvideo(video);
        return "redirect:indexpage";
    }


    @GetMapping("/editvideo")
    public String editvideoAction(Model model, @RequestParam(name = "id") Integer id) {
        Video video = videoManager.getVideoById(id);
        if (video != null) {
            model.addAttribute("videoToBeUpdated", video);
            return "modifiervideo";
        } else {
            return "error";
        }
    }


    @GetMapping("/indexpage")
    public String listProduits(Model model,

                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword
    ) {

        Page<Video> videos = videoManager.searchVideo(keyword, page, taille);
        model.addAttribute("listvideos", videos.getContent());
        int[] pages = new int[videos.getTotalPages()];

        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "indexlayout";
    }

}

