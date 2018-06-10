package com.tyyd.fastdfs.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.csource.fastdfs.StorageClient;

import com.tyyd.fastdfs.FastDFSTemplateFactory;

/**
 * FastDFS 连接池工厂
 */
public class ConnectionPoolFactory {

    private GenericObjectPool<StorageClient> pool;


    public ConnectionPoolFactory(FastDFSTemplateFactory fastDFSTemplateFactory) {
        pool = new GenericObjectPool<>(new ConnectionFactory(fastDFSTemplateFactory));
    }

    public StorageClient getClient() throws Exception {
        return pool.borrowObject();
    }

    public void releaseConnection(StorageClient client) {
        try {
            pool.returnObject(client);
        } catch (Exception ignored) {
        }
    }

}