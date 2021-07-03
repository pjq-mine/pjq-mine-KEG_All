package com.ysu.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadUtil {
    public static String uploads(MultipartFile file, String destDir, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        String suffixStrs = "bmp|jpg|png|tiff|gif";

//        String realPath = request.getSession().getServletContext().getRealPath("/");
//        String rootPath = this.getClass().getResource("/").getPath().replaceAll("^\\/", "");
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath().replaceAll("^\\/", "");
//        System.out.println(rootPath);
//        System.out.println(realPath);
//        System.out.println(filePath);

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//        if (!suffixStrs.contains(suffix)) {
//            throw new Exception("上传文件格式不正确！");
//        }

        String filepath = destDir + File.separator + createNewDir();
        File destFile = new File(rootPath + filepath);
        if (!destFile.exists()){
            destFile.mkdirs();
        }

        String fileNewName = getFileNameNew() + "." + suffix;
        File f = new File(destFile.getAbsoluteFile() + File.separator + fileNewName);
        if (f.exists()) {
            return filepath + File.separator + fileNewName;
        }
        file.transferTo(f);
        f.createNewFile();
        return filepath + File.separator + fileNewName;
    }

    private static String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }

    private static String createNewDir(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(new Date());
    }
}
