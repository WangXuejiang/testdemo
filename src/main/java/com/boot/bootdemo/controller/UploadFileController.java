package com.boot.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class UploadFileController {
    private final String UPLOAD_PATH = "D:\\temp\\";

    @RequestMapping("/")
    public String index() {
        return "upload";
    }

    @RequestMapping("/uploadresult")
    public String result() {
        return "uploadresult";
    }

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file,
    RedirectAttributes redirectAttributes) {
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","请选择一个文件");
            return "redirect:/uploadresult";
        }
        try {
            byte[] bytes=file.getBytes();
            String path=UPLOAD_PATH+file.getOriginalFilename();
            Files.write(Paths.get(path),bytes);
            redirectAttributes.addFlashAttribute("message","上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadresult";

    }
}
