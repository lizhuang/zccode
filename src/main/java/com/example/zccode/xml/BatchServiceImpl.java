package com.example.zccode.xml;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BatchServiceImpl implements SaltFileService<BatchActiveSC> {


//    /**
//     * XML文件保存路径
//     */
//    @Value("${nation.source.platform.path}")
//    private String filePath;
//    /*
//    * 创建BatchActiveSC的xml文件格式压缩成zip
//    * */
//    @Override
//    public ResponseInfo<String> createFile(BatchActiveSC batchActiveSC, String fileName) {
//        String batchXMLFile = XStreamUtil.beanToXml(batchActiveSC);
//        String zipPath = null;
//
//        String fileSeparator =  System.getProperty("file.separator");
//
//        if(StringUtils.isBlank(filePath)){
//            return ResponseInfo.makeAnResponseInfo(ResultCode.FAIL, "写xml文件路径没有设置");
//        }
//
//        if(!filePath.endsWith(fileSeparator)){
//            StringBuffer stringBuffer = new StringBuffer();
//            filePath = stringBuffer.append(filePath).append(fileSeparator).toString();
//        }
//
//        File dic = new File(filePath);
//        if(!dic.exists()){
//            dic.mkdirs();
//        }
//
//        try {
//            StringBuffer xmlPathStringBuffer = new StringBuffer();
//            String xmlPath = xmlPathStringBuffer.append(filePath).append(fileName).append(".xml").toString();
//            if (StringUtils.isNotEmpty(xmlPath)) {
//                File file = new File(xmlPath);
//                if (!file.getParentFile().exists()) {
//                    file.getParentFile().mkdirs();
//                }
//            }
//            //把xml保存到本地
//            Files.write(Paths.get(xmlPath), batchXMLFile.getBytes(Charset.forName("utf-8")), StandardOpenOption.CREATE);
//            //创建压缩文件
//            ZipUtils zipUtils = new ZipUtils();
//            zipPath = zipUtils.zipFile(xmlPath);
//
//            //读取生成的xml文件
//            File readXMLFile = new File(xmlPath);
//            if(readXMLFile.exists()){
//               readXMLFile.delete();
//            }
//        }catch (IOException e){
//            log.error("写入批次文件出错!");
//            log.error(e.getMessage(), e);
//            return ResponseInfo.makeAnResponseInfo(ResultCode.FAIL, "创建失败");
//        }finally {
//            if (zipPath != null) {
//                File f = new File(zipPath);
//                if (f.exists())
//                    return ResponseInfo.makeAnResponseInfo(ResultCode.OK, "创建成功");
//            }
//            return ResponseInfo.makeAnResponseInfo(ResultCode.FAIL, "具体，路径不存在");
//        }
//    }

}
