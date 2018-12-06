package com.example.zccode.service;

import com.example.zccode.dao.CodeDao;
import com.example.zccode.xml.BatchActiveSC;
import com.example.zccode.xml.Code;
import com.example.zccode.xml.XStreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class XMLReaderService {

    @Autowired
    private CodeDao codeDao;

    public void temp() {
        String path = "D:\\salt\\8033\\";

        ArrayList<String> listFileName = new ArrayList<>();

        getAllFileName(path, listFileName);

        for (String name : listFileName) {
            if (name.contains(".xml") && name.contains("BatchActive_SC")) {
                log.debug("{}", name);
                BatchActiveSC batchActiveSC = readFile(name);

                List<Code> codeList = batchActiveSC.getEvents().getEvent().getRelation().getBatch().getCodes();
                String pl = batchActiveSC.getEvents().getEvent().getRelation().getBatch().getWorkShop();
                Date pt = batchActiveSC.getEvents().getEvent().getRelation().getBatch().getProductDate();
                insertCodeList(codeList, pl, pt);
            }
        }


        // log.info("ba:{}", batchActiveSC);
    }

    private void insertCodeList(List<Code> codeList, String pl, Date pt) {
        for (Code code : codeList) {
            com.example.zccode.po.Code code1 = new com.example.zccode.po.Code();
            if (code.getPackLayer().equals("2")) {
                code1.setType(2);
                code1.setPackCode(null);
            } else {
                code1.setType(1);
                code1.setPackCode(code.getParentCode());
            }
            code1.setCode(code.getTraceCode());
            code1.setProductLine(pl);
            code1.setProduceTime(pt);

            codeDao.insertCode(code1);
        }
    }

    public BatchActiveSC readFile(String fileName) {
        try {
            InputStream is = new FileInputStream(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }

            return XStreamUtil.xmlToBean(buffer.toString(), BatchActiveSC.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void getAllFileName(String path, ArrayList<String> listFileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null) {
            String[] completNames = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                completNames[i] = path + names[i];
            }
            listFileName.addAll(Arrays.asList(completNames));
        }
        for (File a : files) {
            if (a.isDirectory()) {//如果文件夹下有子文件夹，获取子文件夹下的所有文件全路径。
                getAllFileName(a.getAbsolutePath() + "\\", listFileName);
            }
        }
    }

}
