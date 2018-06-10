package com.tyyd.fastdfs.mapper;
 

import com.tyyd.fastdfs.FastDfsInfo;
 
public interface FastDfsMapper {
      
    public int add(FastDfsInfo fastDfsInfo);  
      
    public void delete(FastDfsInfo fastDfsInfo);  
      
    public int update(FastDfsInfo fastDfsInfo);
    
    public FastDfsInfo query(FastDfsInfo fastDfsInfo);
}