package com.building.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UploadUtils {

    private static String dir = ConstantUtils.Path.DIRPATH;

    public static Map<String,String> upLoadImage(MultipartFile file){
        Map<String,String> resultMap = new HashMap<String,String>();
        if(file.isEmpty()){
            resultMap.put("failure","传入的文件为空");
            return resultMap;
        }

        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormatDate.format(new Date());

        String fileName = file.getOriginalFilename();
        String realPath = dir + "/" + currentDate + "/";
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        String extName = FilenameUtils.getExtension(fileName);
        String allowImgFormat = "gif,jpg,jpeg,png";

        if (!allowImgFormat.contains(extName.toLowerCase())) {
            resultMap.put("failure", "传入的文件不是图像");
            return resultMap;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd&HH-mm-ss");
        String currentTime = simpleDateFormat.format(new Date());
        fileName = currentTime + UUID.randomUUID() + ".jpg";
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = file.getInputStream();
            fileOutputStream = new FileOutputStream(realPath + fileName);
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (IOException e) {
            resultMap.put("failure", "图片储存失败");
            e.printStackTrace();
            return resultMap;
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        }
        resultMap.put("success", "/" + currentDate + "/" + fileName);
        return resultMap;
    }

    /**
     * 判断对象是否为空，且对象的所有属性都为空
     * ps: boolean类型会有默认值false 判断结果不会为null 会影响判断结果
     *     序列化的默认值也会影响判断结果
     * @param object
     * @return
     */
    public static  boolean objCheckIsNull(Object object){
        Class clazz = (Class)object.getClass(); // 得到类对象
        Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
        boolean flag = true; //定义返回结果，默认为true
        for(Field field : fields){
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(object); //得到属性值
                Type fieldType =field.getGenericType();//得到属性类型
                String fieldName = field.getName(); // 得到属性名
                System.out.println("属性类型："+fieldType+",属性名："+fieldName+",属性值："+fieldValue);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(StringUtils.isNotBlank((CharSequence) fieldValue)){  //只要有一个属性值不为null 就返回false 表示对象不为null
                System.out.println(fieldValue);
                flag = false;
                break;
            }
        }
        return flag;
    }

}
