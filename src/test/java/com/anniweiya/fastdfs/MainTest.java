package com.anniweiya.fastdfs;

import com.tyyd.fastdfs.FastDFSTemplate;
import com.tyyd.fastdfs.FastDfsInfo;
import com.tyyd.fastdfs.exception.FastDFSException;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ProtoCommon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 连接池测试
 *
 * @author KisChang
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-fastdfs.xml")
public class MainTest {

    @Resource
    private FastDFSTemplate dfsTemplate;

    @Test
    public void testUploadAndDel() throws FastDFSException {
        FastDfsInfo rv = dfsTemplate.upload("".getBytes(), "txt");
        System.out.println(rv);
        dfsTemplate.deleteFile(rv);
    }

    @Test
    public void testPool() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                File file = new File("F:\\1.jpg");
                FileInputStream fis = new FileInputStream(file);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                Map<String, String> map = new HashMap<>();
                FastDfsInfo rv = dfsTemplate.upload(b, "jpg", map);
                System.out.println(rv.getFileAbsolutePath());
                dfsTemplate.deleteFile(rv);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 1; i++) {
            new Thread(runnable).start();
        }
        Thread.currentThread().join();
    }
    @Test
    public void testUploadAndGet() throws FastDFSException {
        FastDfsInfo rv = dfsTemplate.upload("123213".getBytes(), "txt");
        System.out.println(rv);
        byte[] bytes =  dfsTemplate.loadFile(rv);
        System.out.println(new String(bytes));
    }
    @Test
    public void testUploadAndGetMata() throws FastDFSException {
        FastDfsInfo rv = dfsTemplate.upload("123213".getBytes(), "txt");
        System.out.println(rv);
        NameValuePair pair = new NameValuePair();
        pair.setName("title");
        pair.setValue("112321321");
        NameValuePair pair2 = new NameValuePair();
        pair2.setName("name");
        pair2.setValue("1.txt");
        NameValuePair[] pair1 = {pair , pair2};
        dfsTemplate.setMetadata(rv, pair1, ProtoCommon.STORAGE_SET_METADATA_FLAG_OVERWRITE);
        NameValuePair[] pairs =  dfsTemplate.getMetadata(rv);
        System.out.println(Arrays.toString(pairs));
    }
}