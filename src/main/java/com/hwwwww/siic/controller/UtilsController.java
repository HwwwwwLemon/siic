package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.utils.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/13 11:54
 */
@RestController
@RequestMapping("/util")
@Slf4j
public class UtilsController {
    @RespBodyResMapping(value = "/uploads")
    public String file(@RequestParam("file") List<MultipartFile> uploads, @RequestParam Map<String, Object> params) throws IOException {
        String originName = "";
        String path = ResourceUtils.getURL("classpath:static").getPath() + "/";
        if (uploads != null && uploads.size() > 0) {
            for (MultipartFile file : uploads) {
                originName = file.getOriginalFilename();
                String fileName = originName + GeneralUtil.getExtensionName(originName);
                File f = new File(path + fileName);
                log.info("File_Path" + path + fileName);
                file.transferTo(f);
                if (f.exists()) {
                    System.out.println(originName);
                    return originName;
                }
            }
        }
        return "err" + originName;
    }
}
